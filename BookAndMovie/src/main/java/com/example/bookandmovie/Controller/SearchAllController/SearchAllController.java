package com.example.bookandmovie.Controller.SearchAllController;

import com.example.bookandmovie.Controller.EditDistance;
import com.example.bookandmovie.Entity.*;
import com.example.bookandmovie.Service.*;
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
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private DiscussService discussService;

    public Map<String, Object> searchBook(@RequestBody String key)
    {
        List<Book> books= bookService.listBook();
        Map<String, Object> remap=new HashMap<>();
        List<Map> arr=new ArrayList<>();
        EditDistance editDistance=new EditDistance();
        int editD;
        for(Book b:books)
        {
            editD=editDistance.solve(b.getBookname(),key);
            if(editD<b.getBookname().length())
            {
                Map<String,Object> map_temp=new HashMap<>();
                map_temp.put("bookname",b.getBookname());
                map_temp.put("src", b.getSrc());
                map_temp.put("book_id", b.getBook_id());
                map_temp.put("score", b.getScore());
                map_temp.put("author", b.getAuthor());
                map_temp.put("press", b.getPress());
                arr.add(map_temp);
            }
        }
        remap.put("messages",arr);
        return remap;
    }

    public Map<String, Object> searchMovie(@RequestBody String key)
    {
        List<Movie> movies= movieService.listMovie();
        Map<String, Object> remap=new HashMap<>();
        List<Map> arr=new ArrayList<>();
        EditDistance editDistance=new EditDistance();
        int editD;
        System.out.println(key);
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
                map_temp.put("brief_introduction",e.getBrief_introduction());
                arr.add(map_temp);
            }
        }
        remap.put("messages",arr);
        return remap;
    }

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

    public Map<String, Object> searchGroup(@RequestBody Map<Object, Object> remap) {

        String text = (String) remap.get("searchtext");

        Map<String, Object> map = new HashMap<>();

        List<Groupt> grpArr = discussService.findGroupAll();
        EditDistance editDistance = new EditDistance();
        List<Map> arr = new ArrayList<>();
        for (Groupt e : grpArr) {
            if (editDistance.solve(e.getName(), text) < e.getName().length()) {
                Map<String, Object> temp = new HashMap<>();
                temp.put("gid", e.getGid());
                temp.put("src", e.getSrc());
                temp.put("number", e.getNumber());
                temp.put("response", e.getResponse());
                temp.put("introduction", e.getIntroduction());
                User user = userService.selectUserByUid(e.getLeader());
                temp.put("leader", user.getUsername());
                temp.put("name", e.getName());
                temp.put("time", e.getTime());
                arr.add(temp);
            }
        }
        map.put("listGroup", arr);
        map.put("count", arr.size());
        return map;
    }

    /*@PostMapping("/api/searchall/search")
    public Map<String, Object> searchAll(@RequestBody String key) throws Exception{
        System.out.println("this is 1");
        String getManageUrl = ResourceUtils.getURL("src/main/java/com.example.bookandmovie/Controller").getPath();
        System.out.println(getManageUrl);
        Map<String, Object> remap = new HashMap<>();
        Map temp = new HashMap<>();
        List<Map> list = new ArrayList<>();
        List<String> urls = new ArrayList<>();

        urls.add(getManageUrl+"api/book/booksearch?key=" + key);
        urls.add(getManageUrl+"api/movie/moviesearch?key=" + key);
        urls.add(getManageUrl+"api/topic/topicsearch?key=" + key);
//        urls.add(getManageUrl+"/api/group/groupsearch" + key);

        for(String s : urls){
            System.out.println(s);
            temp = restTemplate.getForObject(s, Map.class);
            list.add(temp);
        }

        remap.put("message", list);

        return remap;
    }*/

    @PostMapping("/api/searchall/search")
    public Map<String, Object> searchAll(@RequestBody String key){
        Map<String, Object> remap = new HashMap<>();

        remap.put("书籍查找结果", searchBook(key));
        remap.put("电影查找结果", searchMovie(key));
        remap.put("话题查找结果", searchTopic(key));
        //特殊处理一下
        Map<Object, Object> temp = new HashMap<>();
        temp.put("searchtext", key);
        remap.put("小组查找结果", searchGroup(temp));

        return remap;
    }
}
