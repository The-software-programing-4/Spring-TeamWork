package com.example.bookandmovie.Controller.User;

import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private UserService userSevice;
    @Autowired
    private HttpServletRequest request;
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
                User user = new User(username,password);
                user.setSrc("templates/userImg/0.jpg");
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
    public Map<String,Object> login(@RequestBody Map<String,String> re_map){
        String username = re_map.get("username");
        Map<String,Object> map = new HashMap<>();
        HttpSession session=request.getSession();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }
        else {System.out.println("no cookies");}
        try {
            String usernameA = (String) request.getSession().getAttribute("username");
            map.put("success",true);
            map.put("message",usernameA+"用户已登陆");
            if(usernameA!=null)
                return map;
        }catch (Exception e) {
            System.out.println("no session");
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
                    map.put("uid",user.get_id());
                    session.setAttribute("username",username);
                    session.setAttribute("password",password);
                    session.setAttribute("uid",user.getS_id());
                    Integer t1=(Integer)request.getSession().getAttribute("uid");
                    String r1=(String)request.getSession().getAttribute("username");
                    map.put("t1",t1);   map.put("r1",r1);
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
                    map.put("uid",user.getS_id());
                    session.setAttribute("username",username);
                    session.setAttribute("password",password);
                    session.setAttribute("uid",user.get_id());
                    Integer t1=(Integer)request.getSession().getAttribute("uid");
                    String r1=(String)request.getSession().getAttribute("username");
                    map.put("t1",t1);   map.put("r1",r1);
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
    public Map<String,Object> check() {

        String username = (String) request.getSession().getAttribute("username");
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        Map<String, Object> map = new HashMap<>();
        try {
            User user = userSevice.selectUserByUsername(username);
            if (user == null) {
                map.put("success", false);
                map.put("message", "请重新登陆");
            } else {
                    map.put("success", true);
                    map.put("username", username);
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
    public String updateImg( @RequestParam MultipartFile file,@RequestParam int uid){
        HttpSession session= request.getSession();
       // uid = (int) session.getAttribute("uid");

        String root = System.getProperty("user.dir");
        String originalFileName = file.getOriginalFilename();
        String fileType = originalFileName.substring(Objects.requireNonNull(originalFileName).lastIndexOf("."));
        File fileStore = new File(root + "/src/main/resources/templates/userImg", uid+fileType);
        String url = "templates/userImg/"+uid+fileType;
        if(uid==0)
            return "用户未登陆";
        userSevice.addImg(url,uid);
        try {
            file.transferTo(fileStore);
        } catch (Exception e) {
            return "文件写入失败!";
        }

        return "Upload file success : " + file.getOriginalFilename();
    }
    @GetMapping("api/user/getimg")
    public Map<String,Object> getImg()
    {
        HttpSession session=request.getSession();
        int uid = (int) session.getAttribute("uid");
        Map<String,Object> map = new HashMap<>();
        User user=null;
        user=userSevice.selectUserByUid(uid);
        map.put("username",uid);
        if(user!=null)
        map.put("message",user.getSrc());
        return map;
    }
}
