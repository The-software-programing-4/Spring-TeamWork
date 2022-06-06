package com.example.bookandmovie.Controller.Group;

import com.example.bookandmovie.Dao.UserDao;
import com.example.bookandmovie.Entity.Discuss;
import com.example.bookandmovie.Entity.Group;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.DiscussService;
import com.example.bookandmovie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class GroupController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussService discussService;

    @PostMapping("/api/group/uploadimg")
    public Map<String, Object> updateImg(@RequestBody MultipartFile file) {

        String root = System.getProperty("user.dir");
        System.out.println("start handle picture");
        Map<String, Object> map = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        String path1 = root + "/src/main/resources/templates/groupImg";
        File f = new File(path1);
        int num = 0;
        if (f.isDirectory()) {
            File flist[] = f.listFiles();
            num = flist.length + 1;
        }
        String url = "/templates/groupImg/" + num + ".jpg";
        File fileStore = new File(root + "/src/main/resources/templates/groupImg", num + ".jpg");
        try {
            file.transferTo(fileStore);
        } catch (Exception e) {
            map.put("message", "文件写入失败");
            map.put("errno", 1);
            System.out.println("add picture flase" + url);
            return map;
        }
        System.out.println("add picture success");
        data.put("url", url);
        data.put("alt", "picture");
        data.put("href", url);
        map.put("data", data);
        map.put("errno", 0);
        return map;
    }

    @PostMapping("/api/group/addgroup")
    public Map<String, Object> addGroup(@RequestBody Map<Object, Object> remap) {
        String name = (String) remap.get("name");
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse((String) remap.get("day"));
        } catch (Exception e) {
            System.out.println("日期转换异常");
        }
        String src = "/templates/groupHead/";
        int leader = (int) remap.get("leader");
        String introduction = (String) remap.get("introduction");
        String tags = (String) remap.get("tags");

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "create group");
        return map;
    }

    @PostMapping("/api/group/adddiscuss")
    public Map<String, Object> addDiscuss(@RequestBody Map<Object, Object> remap) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession();

        int uid = (int) session.getAttribute("uid");
        int gid = (int) remap.get("gid");
        String content = (String) remap.get("content");
        String title = (String) remap.get("title");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        try {
            time = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(sdf.format(time));
        } catch (Exception e) {
            map.put("message", "date wrong");
            return map;
        }
        Discuss discuss = new Discuss(uid, gid, content, title, 0, 0, time);
        discussService.addDiscuss(discuss);
        map.put("success", true);
        map.put("message", "add success");
        return map;
    }

    @PostMapping("/api/group/getdiscuss")
    public Map<String, Object> getDiscuss(@RequestBody Map<Object, Object> remap) {
        Map<String, Object> map = new HashMap<>();
        int id = (int) remap.get("id");
        Discuss discuss = discussService.getDiscussById(id);
        map.put("id", discuss.getId());
        map.put("uid", discuss.getUid());
        map.put("gid", discuss.getGid());
        map.put("content", discuss.getContent());
        map.put("title", discuss.getTitle());
        map.put("thumb", discuss.getThumb());
        map.put("response", discuss.getRespose());
        map.put("time", discuss.getTime());
        return map;
    }

    @PostMapping("/api/group/listdiscuss")
    public Map<String, Object> listDiscuss() {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        List<Discuss> disArr = discussService.listDiscussU(uid);
        List<Map> arr = new ArrayList<>();
        for (Discuss e : disArr) {
            Map<String, Object> temp = new HashMap<>();
            temp.put("id", e.getId());
            temp.put("name", e.getTitle());
            temp.put("respose", e.getRespose());
            Group group = discussService.findGroupByGid(e.getGid());
            temp.put("leader", group.getName());
            temp.put("time", e.getTime());
            arr.add(temp);
        }
        map.put("listDiscuss", arr);
        map.put("count", arr.size());
        return map;
    }

    @PostMapping("/api/group/listgroup")
    public Map<String, Object> listGroup() {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        List<Group> grpArr = discussService.findGroupUidIn(uid);
        List<Map> arr = new ArrayList<>();
        for (Group e : grpArr) {
            Map<String, Object> temp = new HashMap<>();
            temp.put("gid", e.getGid());
            temp.put("src", e.getSrc());
            temp.put("number", e.getNumber());
            temp.put("name", e.getName());
            arr.add(temp);
        }
        map.put("listGroup", arr);
        map.put("count", arr.size());
        return map;
    }

    @PostMapping("/api/group/getmember")
    public Map<String, Object> getMember(@RequestBody Map<Object, Object> remap) {
        Map<String, Object> map = new HashMap<>();
        int gid = (int) remap.get("gid");
        List<User> memberlist = discussService.findMemberByGid(gid);
        List<Map> arr = new ArrayList<>();
        for (User e : memberlist) {
            Map<String, Object> temp = new HashMap<>();
            temp.put("src", e.getSrc());
            temp.put("name", e.getUsername());
            arr.add(temp);
        }
        map.put("memberData", arr);
        map.put("count", arr.size());
        return map;
    }

    @PostMapping("/api/group/getgroup")
    public Map<String, Object> getGroup(@RequestBody Map<Object, Object> remap) {
        Map<String, Object> map = new HashMap<>();
        int gid = (int) remap.get("gid");
        Group group = discussService.findGroupByGid(gid);
        Map<String, Object> tmap = new HashMap<>();
        tmap.put("gid", group.getGid());
        tmap.put("uid", group.getLeader());
        tmap.put("name", group.getName());
        tmap.put("time", group.getDate());
        tmap.put("src", group.getSrc());
        User user = userService.selectUserByUid(group.getLeader());
        tmap.put("leader", user.getUsername());
        tmap.put("number", group.getNumber());
        tmap.put("response", group.getResponse());
        tmap.put("introduction", group.getIntroduction());
        map.put("groupData", tmap);
        map.put("message", "success");
        return map;
    }

    @PostMapping("/api/group/listdiscussingroup")
    public Map<String, Object> listDiscussInGroup(@RequestBody Map<Object, Object> remap) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        int gid = (int) remap.get("gid");
        List<Discuss> disArr = discussService.listDiscussG(gid);
        List<Map> arr = new ArrayList<>();
        for (Discuss e : disArr) {
            Map<String, Object> temp = new HashMap<>();
            temp.put("gid", e.getGid());
            User user = userService.selectUserByUid(e.getUid());
            temp.put("author", user.getUsername());
            temp.put("respose", e.getRespose());
            temp.put("thumb", e.getThumb());
            arr.add(temp);
        }
        map.put("discussData", arr);
        map.put("count", arr.size());
        return map;
    }

    @PostMapping("/api/group/groupsearch")
    public Map<String, Object> listDiscussInGroup(@RequestBody Map<Object, Object> remap) {
    {
        Map<String, Object> map = new HashMap<>();
        String text=(String) remap.get("searchtext");

    }
}


