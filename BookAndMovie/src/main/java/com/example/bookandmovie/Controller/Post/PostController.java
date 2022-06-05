package com.example.bookandmovie.Controller.Post;

import com.example.bookandmovie.Entity.Post;
import com.example.bookandmovie.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/api/post/findPost")
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

    @PostMapping("/api/post/addPost")
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
}
