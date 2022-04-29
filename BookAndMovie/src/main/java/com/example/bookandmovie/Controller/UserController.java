package com.example.bookandmovie.Controller;

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
public class UserController {
    @Autowired
    private UserSevice userSevice;
    @PostMapping("api/user/register")
    public Map<String,Object> register(@RequestBody Map<String,String> re_map){
        String username = re_map.get("username");
        String password = re_map.get("password");
        String birthday = re_map.get("birthday");
        Map<String,Object> map = new HashMap<>();
        try{
            //Student student = new Student(username,password);
            User user1 = userSevice.selectUserByUsername(username);
            if(user1 != null){
                map.put("success",false);
                map.put("message","用户名已注册");
            }
            else{
                User user = new User(username,password);
                userSevice.registerNewUser(user);
                map.put("success",true);
                map.put("message","用户注册成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","用户注册失败");
        }
        return map;
    }
    @PostMapping("/login")
    public Map<String,Object> login(HttpSession session,@RequestBody Map<String,String> re_map){
        String username = re_map.get("username");
        String password = re_map.get("password");
        Map<String,Object> map = new HashMap<>();
        try{
            User user = userSevice.selectUserByUsername(username);
            User user_e = userSevice.selectUserByEmail(username);

            if(user == null && user_e == null){
                map.put("success",false);
                map.put("message","用户名或邮箱不存在");
            }
            else if(user == null)
            {
                user = user_e;
                if((user.getPassword()).equals(password))
                {
                    map.put("success",true);
                    map.put("message",username+"登录成功");
                    session.setAttribute("username",username);
                }
                else{
                    map.put("success",false);
                    map.put("message",username+"密码错误");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","其他错误导致登录失败");
        }
        return map;
    }
    @PostMapping("/check")
    public Map<String,Object> check(HttpSession session) {

        String username = (String) session.getAttribute("username");
        Map<String, Object> map = new HashMap<>();
        try {
            User user = userSevice.selectUserByUsername(username);
            if (user == null) {
                map.put("success", false);
                map.put("message", "请重新登陆");
            } else {
                    map.put("name", username);
                    map.put("password", user.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "其他错误导致查找失败");
        }
        return map;
    }
}
