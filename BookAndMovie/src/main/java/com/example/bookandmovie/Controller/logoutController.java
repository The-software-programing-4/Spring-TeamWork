package com.example.bookandmovie.Controller;

import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class logoutController {
    @Autowired
    private UserSevice userService;
    @PostMapping("/logout")
    public Map<String, Object> logout(HttpSession session)
    {
        String username = (String) session.getAttribute("username");
        Map<String,Object> map = new HashMap<>();
        try{
            User user = userService.selectUserByUsername(username);
            if (user != null) {
                session.invalidate();
                map.put("success",true);
                map.put("message",username+"注销成功");
            } else {
                map.put("success", false );
                map.put("message", "未登陆");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "其他错误导致注销失败");
        }
        return map;
    }
}
