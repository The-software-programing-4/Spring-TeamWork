package com.example.bookandmovie.Controller.User;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.Fetch;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    private UserSevice userSevice;
    HttpSession session;
    @PostMapping("api/user/register")
    public Map<String,Object> register(@RequestBody Map<String,String> re_map){
        String username = re_map.get("username");
        String password = re_map.get("password");
        Map<String,Object> map = new HashMap<>();
        try{
            //Student student = new Student(username,password);
            User user1 = userSevice.selectUserByUsername(username);
            if(user1 != null){
                map.put("success",false);
                map.put("message","用户名已注册");
            }
            else{
                User user = new User(username,password,2);
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
    @PostMapping("api/user/login")
    public Map<String,Object> login(HttpSession session,@RequestBody Map<String,String> re_map){
        String username = re_map.get("username");
        Map<String,Object> map = new HashMap<>();
        try {
            String usernameA = (String) session.getAttribute("username");
            map.put("success",false);
            map.put("message",usernameA+"用户已登陆");
            if(usernameA!=null)
            return map;
        }catch (Exception e) {

        }
        String password = re_map.get("password");

        map.put("success","unknown");
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
                    map.put("uid",user.getUser_id());
                    session.setAttribute("username",username);
                    session.setAttribute("password",password);
                    session.setAttribute("uid",user.getUser_id());
                }
                else{
                    map.put("success",false);
                    map.put("message",username+"密码错误");
                }
            }
            else{
                if((user.getPassword()).equals(password))
                {
                    map.put("success",true);
                    map.put("message",username+"登录成功");
                    map.put("uid",user.getUser_id());
                    session.setAttribute("username",username);
                    session.setAttribute("password",password);
                    session.setAttribute("uid",user.getUser_id());
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
    @PostMapping("api/user/check")
    public Map<String,Object> check(HttpSession session) {

        String username = (String) session.getAttribute("username");
        Integer uid = (Integer) session.getAttribute("uid");
        Map<String, Object> map = new HashMap<>();
        try {
            User user = userSevice.selectUserByUsername(username);
            if (user == null) {
                map.put("success", false);
                map.put("message", "请重新登陆");
            } else {
                    map.put("name", username);
                    map.put("password", user.getPassword());
                    map.put("uid",uid);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "其他错误导致查找失败");
        }
        return map;
    }
    @PostMapping("/api/user/imgUpload")
    public String updateImg(HttpSession session, @RequestBody MultipartFile file,String username){
        //String username = (String) session.getAttribute("username");
        String root=System.getProperty("user.dir");
        String status=new String();
        status="_new";
        //System.out.println(root);
        if(username==null)
            return "用户未登陆";
        String path1=root+"/src/main/resources/templates/userImg/"+username+".jpg";
        String path2=root+"/src/main/resources/templates/userImg/"+username+status+".jpg";
        File fileEx1=new File(path1);
        File fileEx2=new File(path2);
        if(fileEx1.exists())
        {
            fileEx1.delete();
        }
        else if(fileEx2.exists()){
            fileEx2.delete();
            status="";
        }
        File fileStore=new File(root+"/src/main/resources/templates/userImg",username+status+".jpg");
        try{file.transferTo(fileStore);}
        catch (Exception e){
            return "文件写入失败";
        }
        return "Upload file success : " + file.getOriginalFilename();
    }
    @GetMapping("api/user/getImg")
    @ResponseBody
    public Map<String,Object> getImg(HttpSession session)
    {
        String username = (String) session.getAttribute("username");
        Map<String,Object> map = new HashMap<>();
        if(username==null)
        {
            map.put("username",username);
            map.put("message",null);
            return map;
        }
        System.out.println("开始获取图片"+username);
        String root=System.getProperty("user.dir");
        String status="_new";
        String path1=root+"/src/main/resources/templates/userImg/"+username+".jpg";
        String path2=root+"/src/main/resources/templates/userImg/"+username+status+".jpg";
        File file1=new File(path1);
        File file2=new File(path2);
        if(file1.exists())
        {
            status="";
        }
        else if(file2.exists())
            status="_new";
        else{
            map.put("username",username);
            map.put("message",null);
            return map;
        }
        map.put("username",username);
        map.put("message","templates/userImg/"+username+status+".jpg");
        return map;
    }
}
