package com.example.bookandmovie.Controller.movie;

import com.example.bookandmovie.Entity.Movie;
import com.example.bookandmovie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Lob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class movieMain {
    @Autowired
    private MovieService movieService;
    @PostMapping("/api/movie/message_get")
    public Map<String, Object> message_get(@RequestBody String name)
    {
        Map<String ,Object> map=new HashMap<>();
        return map;
    }
    @PostMapping("/api/movie/message_set")
    public Map<String, Object> message_set(@RequestBody Map<Object,Object> map)
    {
        Map<String ,Object> remap=new HashMap<>();
        Date date =new Date();
        int mid=(int)map.get("mid");
        String src=(String)map.get("src");
        String name=(String)map.get("name");
        String actors=(String)map.get("actors");
        String directors=(String)map.get("directors");
        String writers=(String)map.get("writers");
        String category=(String)map.get("category");
        String language=(String)map.get("language");
        int length=(int)map.get("length");
        String position=(String)map.get("position");
        String IMDb=(String)map.get("IMDb");
        double score=(double)map.get("score");
        String brief_introduction = (String) map.get("brief_introduction");;
        try {
             date= new SimpleDateFormat("yyyy-MM-dd").parse((String)map.get("date"));
        }catch (Exception e){   System.out.println("date Wrong in movie"); }
        Movie movie=new Movie(mid, src, name, actors, directors, writers,  category, language, length, date, position, IMDb,  score,  brief_introduction);
        movieService.addMovie(movie);
        remap.put("message","success");
        return remap;
    }
    @PostMapping("/api/movie/message_set")
    public Map<String, Object> message_set(@RequestBody String movie)
    {
        Map<String ,Object> remap=new HashMap<>();
        Movie m = movieService.findMovie(movie);
        return remap;
    }

}
