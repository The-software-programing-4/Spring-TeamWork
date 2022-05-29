package com.example.bookandmovie.Controller.Marks;

import com.example.bookandmovie.Entity.Book;
import com.example.bookandmovie.Entity.Mark;
import com.example.bookandmovie.Entity.Movie;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.BookService;
import com.example.bookandmovie.Service.MarkService;
import com.example.bookandmovie.Service.MovieService;
import com.example.bookandmovie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class marksController {
    @Autowired
    private MarkService markService;
    @Autowired
    private BookService bookService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;
    @PostMapping("/api/marks/addmark")
    public String addMark(@RequestBody Map<String, Object> map) {
        int id = (int) map.get("id");
        int type = (int) map.get("type");
        int target = (int) map.get("target");
        int uid = (int) map.get("uid");

        String content = (String) map.get("content");
        Date day = new Date();
        double score = (double) map.get("score");
        try {
            day = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse((String) map.get("day"));
        } catch (Exception e) {
            System.out.println("日期转换异常");
        }

        int thumb = (int) map.get("thumb");
        int reply = (int) map.get("reply");
        Mark mark = new Mark(id, type, target, uid, content, score, day, thumb, reply);
        try {
            markService.addMark(mark);
            markService.replyadd(target);
            updateScore(type,target,score);
        } catch (Exception e) {
            System.out.println("数据库插入异常");
        }
        return "添加评论成功!";
    }

    @PostMapping("/api/marks/getmark")
    public Map<String, Object> getMark(HttpSession session,@RequestBody Map<String, Object> map) {
        int type = (int) map.get("type");
        int target = (int) map.get("target");
        int uid= (int)session.getAttribute("uid");
        List<Mark> marks ;
        marks = markService.getMark(type, target);
        Map<String, Object> remap = new HashMap<>();
        int count = marks.size();
        List<Map> arr = new ArrayList<>();
        for (Mark e : marks) {
            Map<String, Object> map_temp = new HashMap<>();
            map_temp.put("id", e.getId());
            map_temp.put("type", e.getType());
            map_temp.put("target", e.getTarget());
            map_temp.put("uid", e.getUid());
            User user=userService.selectUserByUid(e.getUid());
            map_temp.put("username",user.getUsername());
            map_temp.put("content", e.getContent());
            map_temp.put("score", e.getScore());
            map_temp.put("day", e.getDay());
            map_temp.put("thumb", e.getThumb());
            map_temp.put("reply", e.getReply());
            Mark t=markService.isthumb(uid,e.getId());
            if(t==null) map_temp.put("isthumb","点赞");
            else map_temp.put("isthumb","已点赞");
            arr.add(map_temp);
        }
        remap.put("marks", arr);
        remap.put("count", count);
        remap.put("success", true);
        return remap;
    }

    @PostMapping("/api/marks/thumb")
    public String thumbChange(HttpSession session,@RequestBody Map<String, Object> map) {
        int uid= (int)session.getAttribute("uid");
        int op=(int)map.get("op");
        int target=(int)map.get("target");
        try{markService.thumbChange(target,op,uid);}
        catch (Exception e){System.out.println("点赞修改成功");}
        return "点赞修改失败";
    }
    public String updateScore(int type,int target,double score)
    {
        double re;
        if(type == 1)
        {
            int count=markService.countMark_book(target);
            Book book = bookService.selectBookByBook_id(target);
            double score_orin=book.getScore();
            if(count==0) re=score;
            else {
                re=(count*score_orin+score)/count+1;
            }
            markService.culMark_book(target,re);
        }
        else if(type == 2)
        {
            int count=markService.countMark_movie(target);
            Movie movie = movieService.findMovieById(target);
            double score_orin=movie.getScore();
            if(count==0) re=score;
            else {
                re=(count*score_orin+score)/count+1;
            }
            markService.culMark_movie(target,re);
        }
        else return "Wrong type!";
        return "success update";
    }

}
