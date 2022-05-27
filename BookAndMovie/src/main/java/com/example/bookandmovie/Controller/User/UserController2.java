package com.example.bookandmovie.Controller.User;

import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController2 {
    @Autowired
    private UserService userService;
    @PostMapping("/api/user/register_e")
    public Map<String, Object> register_e(@RequestBody Map<String, String> re_map){
        String email = re_map.get("email");
        String username = re_map.get("username");
        String vercode = re_map.get("vercode");
        String password = re_map.get("password");//说明文档里面没有提到密码这个参数 需要补上
        Map<String, Object> map = new HashMap<>();
        try{
            User user1 = userService.selectUserByEmail(email);
            User user2 = userService.selectUserByUsername(username);
            if(user1 != null){
                map.put("success", false);
                map.put("message", "邮箱已注册！");
            }else if(user2 != null){
                map.put("success", false);
                map.put("message", "用户名已存在");
            }
            else {
                if(vercode.equals("123456")){
                    User user3 = new User(email, password, 1);
                    user3.setUsername(username);//设置用户名
                    userService.registerUserByEmail(user3);//注意改动时会产生的问题
                    map.put("success", true);
                    map.put("message", "使用邮箱注册用户成功！");
                }
                else {
                    map.put("success", false);
                    map.put("message", "验证码错误！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", "false");
            map.put("message", "用户注册失败！");
        }
        return map;
    }
    @PostMapping("/api/user/register_p")
    public Map<String, Object> register_p(@RequestBody Map<String, String> re_map){
        String phone = re_map.get("phone");
        String username = re_map.get("username");
        String password = re_map.get("password");
        String vercode = re_map.get("vercode");
        Map<String, Object> map = new HashMap<>();
        try{
            User user1 = userService.selectUserByPhone(phone);
            User user2 = userService.selectUserByUsername(username);
            if(user1 != null){
                map.put("success", false);
                map.put("message", "该手机号已注册！");
            }else if(user2 != null){
                map.put("success", false);
                map.put("message", "该用户名已注册！");
            }
            else {
                if(vercode.equals("123456")){
                    User user3 = new User(phone, password, 2);
                    user3.setUsername(username);
                    userService.registerUserByPhone(user3);
                    map.put("success", true);
                    map.put("message", "手机号注册用户成功！");
                }
                else {
                    map.put("success", false);
                    map.put("message", "验证码错误！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", "false");
            map.put("message", "用户注册失败！");
        }
        return map;
    }

    //登录
    @RequestMapping("/api/user/login/vercode_e")
    public Map<String, Object> createLoginVercode_e(@RequestBody Map<String, String> re_map){
        String email = re_map.get("email");
        /*
        此处选择合适的方式创建验证码并将其保存
         */
        Map<String, Object> map  = new HashMap<>();
        try{
            User user1 = userService.selectUserByEmail(email);
            if(user1 == null){
                map.put("success", false);
                map.put("message", "该邮箱没有对应用户");
            }else {
                map.put("success", true);
                map.put("message", "验证码已发送");
                map.put("username", user1.getUsername());
            }
        }catch (Exception e){
            map.put("success", false);
            map.put("message", "验证码发送失败！");
        }
        return map;
    }
    @RequestMapping("/api/user/login/email")
    public Map<String , Object> userLoginByEmail(HttpSession session, @RequestBody Map<String, String> re_map){
        String email = re_map.get("email");
        String vercode = re_map.get("vercode");
        Map<String, Object> map = new HashMap<>();
        try {
            String emailA = (String) session.getAttribute("email");
            map.put("success",false);
            map.put("message",emailA+"用户已登陆");
            if(emailA!=null)
                return map;
        }catch (Exception e) {
            //
        }
        try {
            //User user1 = userService.selectUserByUsername(email);//!!!!这个地方得换成新的函数
            User user1 = userService.selectUserByEmail(email);
            if(user1 == null){
                map.put("success", false);
                map.put("message", "该邮箱没有对应用户");
            }
            else {//注意点
                if(user1.getPassword().equals(vercode)){
                    //获取并设置session
                    session.setAttribute("email", email);
                    session.setAttribute("username", user1.getUsername());
                    session.setAttribute("uid", user1.getS_id());
                    //登录成功
                    map.put("success", true);
                    map.put("message", "登录成功！");
                }
                else{
                    map.put("success", false);
                    map.put("message", "验证码错误");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "登录异常！");
        }
        return map;
    }
    @RequestMapping("/api/user/login/vercode_p")//get方式该使用哪种方法
    public Map<String, Object> createLoginVercode_p(@RequestBody Map<String, String> re_map){
        String phone = re_map.get("phone");
        /*
        此处选择合适的方式创建验证码并将其保存
         */
        Map<String, Object> map  = new HashMap<>();
        try{
            User user1 = userService.selectUserByPhone(phone);
            if(user1 == null){
                map.put("success", false);
                map.put("message", "该手机号码没有对应用户");
            }else {
                map.put("success", true);
                map.put("message", "验证码已发送");
                map.put("username", user1.getUsername());
            }
        }catch (Exception e){
            map.put("success", false);
            map.put("message", "验证码发送失败！");
        }
        return map;
    }
    @RequestMapping("/api/user/login/phone")
    public Map<String , Object> userLoginByPhone(HttpSession session, @RequestBody Map<String, String> re_map){
        String phone = re_map.get("phone");
        String vercode = re_map.get("vercode");
        Map<String, Object> map = new HashMap<>();
        try {
            String phoneA = (String) session.getAttribute("phone");
            map.put("success",false);
            map.put("message",phoneA+"用户已登陆");
            if(phoneA!=null)
                return map;
        }catch (Exception e) {
            //
        }
        try {
            //User user1 = userService.selectUserByUsername(email);//!!!!这个地方得换成新的函数
            User user1 = userService.selectUserByPhone(phone);
            if(user1 == null){
                map.put("success", false);
                map.put("message", "该手机号码没有对应用户");
            }
            else {//这个地方该怎么处理？验证码可不是用户的属性啊
                if(user1.getPassword().equals(vercode)){
                    //获取并设置session
                    session.setAttribute("phone", phone);
                    session.setAttribute("username", user1.getUsername());//用户名最好提取出来保存一下
                    session.setAttribute("uid", user1.getS_id());
                    //登录成功
                    map.put("success", true);

                    map.put("username", user1.getUsername());
                }
                else{
                    map.put("success", false);
                    map.put("message", "验证码错误");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "登录异常！");
        }
        return map;
    }

    //注销
    @RequestMapping("api/user/logout")
    public Map<String, Object> userLogout(HttpSession session){
        Map<String, Object> map = new HashMap<>();
        try {
            //注销用户，使session失效
            session.invalidate();
            map.put("success", true);
            map.put("message", "注销成功");
        } catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "注销失败！");
        }
        return map;
    }

    //get/set user中的参数
    /*@RequestMapping("api/user/login/message_set")
    public Map<String, Object> userMessageSet(@RequestBody ConfigurationPropertyName.Form re_form){

    }*/
}
