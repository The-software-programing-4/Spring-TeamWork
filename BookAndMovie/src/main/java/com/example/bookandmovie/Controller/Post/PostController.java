package com.example.bookandmovie.Controller.Post;

import com.example.bookandmovie.Entity.Post;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.PostService;
import com.example.bookandmovie.Service.UserService;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/post/message_get")
    public Map<String, Object> findPost(@RequestBody int pid){
        Map<String, Object> map = new HashMap<>();
        try{
            Post post1 = postService.findPost(pid);
            if(post1 == null){
                map.put("success", false);
                map.put("message", "未找到该帖子！");
            }else{
                map.put("username", post1.getUsername());
                map.put("length", post1.getLength());//有几张图片
                map.put("date", post1.getDate());
                map.put("content", post1.getContent());
                map.put("thumbs", post1.getThumbs());
                map.put("response", post1.getResponse());//表示回应的数量 并不是具体的回应。。。 千万别误会了
                map.put("transmit", post1.getTransmit());//转发数

                map.put("success", true);
                map.put("message", "已找到该帖子！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "查找帖子异常！");
        }
        return map;
    }

    @PostMapping("/api/post/message_set")
    public Map<String, Object> addPost(@RequestBody Map<Object, Object> map){
        Map<String, Object> remap = new HashMap<>();
        Date date = new Date();
        int pid = (int) map.get("mid");
        String username = (String) map.get("username");
        String content = (String) map.get("content");
        Integer thumbs = (Integer) map.get("thumbs");
        Integer response = (Integer) map.get("response");
        Integer transmit = (Integer) map.get("transmit");
        Integer length = (Integer) map.get("length");
        try{
            date = new SimpleDateFormat("yyyy-MM-dd").parse((String)map.get("date"));
        }catch (Exception e){
            System.out.println("date wrong in post");
        }
        Post post = new Post(pid, username, content, thumbs, response, transmit, date, length);
        postService.addPost(post);
        remap.put("message", "success");
        return remap;
    }

    @PostMapping("/api/post/pid2src")
    public Map<String, Object> pid2src(@RequestBody int pid){
        int i;
        int len = postService.srcLength(pid);
        //获取到了src的数量

        List<String> srcs = postService.listSrc(pid);
        //获取到了所有src的值
        List<Map> arr = new ArrayList<>();
        Map<String, Object> remap = new HashMap<>();

        Map<String, Object> map_len = new HashMap<>();
        map_len.put("len", len);
        arr.add(map_len);//将len存入json数据中

        for(i=0;i<len;i++){
            Map<String, Object> map_temp = new HashMap<>();
            map_temp.put("src", srcs.get(i));
            arr.add(map_temp);
        }
        remap.put("message", arr);
        return remap;
    }

    @PostMapping("/api/post/userPost")
    public Map<String, Object> userPost(@RequestBody int uid){
        Map<String, Object> remap = new HashMap<>();
        List<Map> arr = new ArrayList<>();

        User user = userService.selectUserByUid(uid);
        String username = user.getUsername();

        List<Post> postList = postService.userPost(username);
        for(Post post : postList){
            Map<String, Object> temp = new HashMap<>();
            temp.put("id", post.getPid());
            temp.put("username", post.getUsername());
            temp.put("content", post.getContent());
            temp.put("thumb", post.getThumbs());
            temp.put("reply", post.getResponse());
            temp.put("date", post.getDate());
            temp.put("imgList", postService.listSrc(post.getPid()));//获取图片属性
            arr.add(temp);
        }
        remap.put("message", arr);
        return remap;
    }
}
