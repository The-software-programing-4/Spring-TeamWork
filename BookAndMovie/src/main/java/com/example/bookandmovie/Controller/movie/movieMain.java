package com.example.bookandmovie.Controller.movie;

import com.example.bookandmovie.Controller.EditDistance;
import com.example.bookandmovie.Entity.Movie;
import com.example.bookandmovie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Lob;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.ObjIntConsumer;

@RestController
public class movieMain {
    @Autowired
    private MovieService movieService;
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
    @PostMapping("/api/movie/message_get")
    public Map<String, Object> message_get(@RequestBody String movie)
    {
        Map<String ,Object> remap=new HashMap<>();
        Movie m = movieService.findMovie(movie);
        {
            remap.put("message","success");
            remap.put("mid", m.getMid());
            remap.put("src", m.getSrc());
            remap.put("name", m.getName());
            remap.put("actors", m.getActors());
            remap.put("directors", m.getDirectors());
            remap.put("writers", m.getWriters());
            remap.put("category", m.getCategory());
            remap.put("language", m.getLanguage());
            remap.put("length", m.getLength());
            remap.put("date", m.getDate());
            remap.put("position", m.getPosition());
            remap.put("IMDb", m.getIMDb());
            remap.put("score", m.getScore());
            remap.put("brief_introduction", m.getBrief_introduction());
        }

        return remap;
    }
    @PostMapping("/api/movie/listMovie")
    public Map<String, Object> list_movie(@RequestBody String movie)
    {
        List<Movie> movies= movieService.listMovie();
        Map<String, Object> remap=new HashMap<>();
        int i=1;
        List<Map> arr=new ArrayList<>();
        for(Movie e:movies) {
            Map<String,Object> map_temp=new HashMap<>();
            map_temp.put("name", e.getName());
            map_temp.put("src", e.getSrc());
            map_temp.put("mid", e.getMid());
            map_temp.put("score", e.getScore());
            map_temp.put("actors", e.getActors());
            map_temp.put("category", e.getCategory());
            arr.add(map_temp);
            i++;
            if(i>10) break;
        }
        remap.put("messages",arr);
        return remap;
    }
    @PostMapping("/api/movie/moviesearch")
    public Map<String, Object> searchMovie(@RequestBody String key)
    {
        List<Movie> movies= movieService.listMovie();
        Map<String, Object> remap=new HashMap<>();
        List<Map> arr=new ArrayList<>();
        EditDistance editDistance=new EditDistance();
        int editD;
        for(Movie e:movies)
        {
            editD=editDistance.solve(e.getName(),key);
            if(editD<e.getName().length())
            {
                Map<String,Object> map_temp=new HashMap<>();
                map_temp.put("name", e.getName());
                map_temp.put("src", e.getSrc());
                map_temp.put("mid", e.getMid());
                map_temp.put("score", e.getScore());
                map_temp.put("actors", e.getActors());
                map_temp.put("category", e.getCategory());
                arr.add(map_temp);
            }
        }
        remap.put("messages",arr);
        return remap;
    }

}
