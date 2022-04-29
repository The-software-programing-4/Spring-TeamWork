package com.example.bookandmovie.Controller.User;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class changeMessage {
    @PostMapping("api/changeMessage/")
    public String changeMessage(@RequestBody Map<String,Object> re_map){
        return "recieved!";
    }
}
