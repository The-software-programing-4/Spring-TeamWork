package com.example.bookandmovie.Controller.SearchAllController;

import com.example.bookandmovie.Service.BookService;
import com.example.bookandmovie.Service.MovieService;
import com.example.bookandmovie.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchAllController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/api/searchall/search")
    public Map<String, Object> searchAll(@RequestBody String key) throws Exception{
        String getManageUrl = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(getManageUrl);
        Map<String, Object> remap = new HashMap<>();
        Map temp = new HashMap<>();
        List<Map> list = new ArrayList<>();
        List<String> urls = new ArrayList<>();

        urls.add(getManageUrl+"/api/book/booksearch?key=" + key);
        urls.add(getManageUrl+"/api/movie/moviesearch?key=" + key);
        urls.add(getManageUrl+"/api/topic/topicsearch?key=" + key);
//        urls.add(getManageUrl+"/api/group/groupsearch" + key);

        for(String s : urls){
            temp = restTemplate.getForObject(s, Map.class);
            list.add(temp);
        }

        remap.put("message", list);

        return remap;
    }
}
