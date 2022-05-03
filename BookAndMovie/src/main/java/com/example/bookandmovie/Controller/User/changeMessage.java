package com.example.bookandmovie.Controller.User;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class changeMessage {
    @Autowired
    private UserSevice userSevice;
    @PostMapping("api/user/message_set")
    public String changeMessage(@RequestBody Map<Object,Object> re_map){
        User user = new User();
        try {
            user.set_id(Integer.parseInt(re_map.get("uid").toString()));
        }catch (Exception e){
            return "用户UID异常";
        }
        System.out.println((String) re_map.get("username"));
        user.setUsername((String)re_map.get("username"));
        try {
            Calendar calendar = new GregorianCalendar();
            Date birth = new SimpleDateFormat("yyyy-MM-dd").parse((String)re_map.get("date1"));
            calendar.setTime(birth);
            calendar.add(calendar.DATE,1);
            birth=calendar.getTime();
            user.setBirthday(birth);
        }catch (Exception e)
        {
            return "生日转换异常";
        }
        user.setEmail((String)re_map.get("email"));
        user.setLivetown1((String)re_map.get("l1"));
        user.setLivetown2((String)re_map.get("l2"));
        user.setLivetown3((String)re_map.get("l3"));
        user.setHometown1((String)re_map.get("h1"));
        user.setHometown2((String)re_map.get("h2"));
        user.setHometown3((String)re_map.get("h3"));
        user.setBirthOP((String)re_map.get("birthOP"));
        user.setRegionOP((String) re_map.get("regionOP"));
        user.setPhone((String) re_map.get("phone"));
        try {
            userSevice.updateUserMessage(user);
        }catch (Exception e){
            return "数据库插入异常！";
        }
        return "Recieved!";
    }
    @GetMapping("api/user/message_get")
    @ResponseBody
    public Map<String,Object> getMessage(HttpSession session)
    {
        Integer uid = (Integer) session.getAttribute("uid");
        Map<String,Object> map = new HashMap<>();
        System.out.println("开始获取信息"+uid);
        User user = userSevice.selectUserByUid(uid);
        if(user == null) {
            map.put("message","用户未登录");
            return map;
        }
        map.put("uid",user.get_id());
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        map.put("regionOP",user.getRegionOP());
        map.put("date1",user.getBirthday());
        map.put("email",user.getEmail());
        map.put("phone",user.getPhone());
        String[] livetown=new String[3];
        String[] hometown=new String[3];
        livetown[0]=user.getLivetown1();
        livetown[1]=user.getLivetown2();
        livetown[2]=user.getLivetown3();
        hometown[0]=user.getHometown1();
        hometown[1]=user.getHometown2();
        hometown[2]=user.getHometown3();
        map.put("region1",livetown);
        map.put("region2",hometown);
        map.put("birthOP",user.getBirthOP());
        return map;
    }
    @PostMapping("api/user/password_set")
    public Map<String ,Object> changePassword(HttpSession session,@RequestBody Map<Object,String> re_map)
    {
        Integer uid = Integer.valueOf(re_map.get("uid"));
        String password1=re_map.get("password_temp1");
        String password=re_map.get("password_temp");
        User user=new User();
        Map<String ,Object> map=new HashMap<>();
        user=userSevice.selectUserByUid(uid);
        String oldPassword=user.getPassword();
        if(!password.equals(oldPassword))
        {
            map.put("message","原密码错误");
            return  map;
        }
        else {
            userSevice.changPassword(password1,uid);
            map.put("message","修改成功，请重新登陆");
            session.invalidate();
            return  map;
        }
    }
}
