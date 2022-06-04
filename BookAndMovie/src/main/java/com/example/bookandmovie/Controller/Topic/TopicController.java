package com.example.bookandmovie.Controller.Topic;

import com.example.bookandmovie.Entity.Topic;
import com.example.bookandmovie.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @PostMapping("/api/topic/addTopic")
    public Map<String, Object> addTopic(@RequestBody Map<Object, Object> map){
        Map<String, Object> remap = new HashMap<>();
        int tid = (int) map.get("tid");
        int focus = (int) map.get("focus");
        int num = (int) map.get("num");
        String introduction = (String) map.get("introduction");

        Topic topic = new Topic(tid, focus, num, introduction);
        topicService.addTopic(topic);
        remap.put("message", "success");
        return remap;
    }

    @PostMapping("/api/topic/findTopic")
    public Map<String, Object> findTopic(@RequestBody int tid){
        Map<String, Object> remap = new HashMap<>();
        Topic topic = topicService.findTopic(tid);
        {
            remap.put("message", "success");
            remap.put("tid", topic.getTid());
            remap.put("focus", topic.getFocus());
            remap.put("num", topic.getNum());
            remap.put("introduction", topic.getIntroduction());
        }
        return remap;
    }
}
