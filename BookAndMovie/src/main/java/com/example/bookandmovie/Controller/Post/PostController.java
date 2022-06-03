package com.example.bookandmovie.Controller.Post;

import com.example.bookandmovie.Entity.Post;
import com.example.bookandmovie.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
                map.put("src", post1.getSrc());//这个地方还是不太明白前端的需求 返回一个 包含图片地址的字符串数组 可以实现吗 方便实现吗？
                //多加了一个参数 这是src数组的length 表示总共有几张图片
                map.put("length", post1.getSrc().length);//
                map.put("date", post1.getDate());
                map.put("content", post1.getContent());
                map.put("thumbs", post1.getThumbs());
                map.put("response", post1.getResponse());//表示回应的数量 并不是具体的回应。。。 千万别误会了
                map.put("transimit", post1.getTransmit());//转发数

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
}
