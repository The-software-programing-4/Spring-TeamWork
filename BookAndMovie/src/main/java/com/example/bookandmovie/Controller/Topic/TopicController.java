package com.example.bookandmovie.Controller.Topic;

import com.example.bookandmovie.Controller.EditDistance;
import com.example.bookandmovie.Entity.Topic;
import com.example.bookandmovie.Service.TopicService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @PostMapping("/api/topic/message_set")
    public Map<String, Object> message_set(@RequestBody Map<Object, Object> map){
        Map<String, Object> remap = new HashMap<>();
        int tid = (int) map.get("tid");
        int focus = (int) map.get("focus");
        int num = (int) map.get("num");
        String introduction = (String) map.get("introduction");
        String name = (String) map.get("name");

        Topic topic = new Topic(tid, focus, num, introduction, name);
        topicService.addTopic(topic);
        remap.put("message", "success");
        return remap;
    }

    @PostMapping("/api/topic/message_get")
    public Map<String, Object> message_get(@RequestBody int tid){
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

    @PostMapping("/api/topic/listtopic")
    public Map<String, Object> list_topic(){
        List<Topic> topics = topicService.listTopic();
        Map<String, Object> remap = new HashMap<>();
        int i=1;
        List<Map> arr = new ArrayList<>();
        for(Topic t : topics){
            Map<String, Object> map_temp = new HashMap<>();
            map_temp.put("tid", t.getTid());
            map_temp.put("focus", t.getFocus());
            map_temp.put("num", t.getNum());
            map_temp.put("introduction", t.getIntroduction());
            arr.add(map_temp);
            i++;
            if(i>10) break;
        }
        System.out.println("get 10 topics");
        remap.put("message", arr);
        return remap;
    }

    @PostMapping("/api/topic/topicsearch")
    public Map<String, Object> searchTopic(@RequestBody String key){
        List<Topic> topics = topicService.listTopic();
        Map<String, Object> remap = new HashMap<>();
        List<Map> arr = new ArrayList<>();
        EditDistance editDistance = new EditDistance();
        int editD;
        for(Topic t : topics){
            editD = editDistance.solve(t.getName(), key);
            if(editD < t.getName().length()){
                Map<String, Object> map_temp = new HashMap<>();
                map_temp.put("tid", t.getTid());
                map_temp.put("name", t.getName());
                map_temp.put("focus", t.getFocus());
                map_temp.put("num", t.getNum());
                map_temp.put("introduction", t.getIntroduction());
                arr.add(map_temp);
            }
        }
        remap.put("messages", arr);
        return remap;
    }

    @PostMapping("/api/topic/tid2pid")
    public Map<String, Object> tid2pid(@RequestBody Integer tid){
        int len = topicService.pidLength(tid);
        int i;
        //获取到了pid的数量

        List<Integer> pids = topicService.listPid(tid);
        Map<String, Object> remap = new HashMap<>();
        List<Map> arr = new ArrayList<>();
        //获取到了pid的所有值 pids数组

        Map<String, Object> map_len = new HashMap<>();
        map_len.put("len", len);
        arr.add(map_len);
        //将len存入json数据中
        for(Integer integer : pids){
            Map<String, Object> map_temp = new HashMap<>();
            map_temp.put("pid", integer);
            arr.add(map_temp);
        }
        remap.put("message", arr);
        return remap;
    }
}
