package com.example.bookandmovie.Controller.Group;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GroupController {
    @PostMapping("/api/group/uploadimg")
    public Map<String,Object> updateImg(@RequestBody MultipartFile file){

        String root=System.getProperty("user.dir");
        System.out.println("start handle picture");
        Map<String,Object> map=new HashMap<>();
        Map<String,String> data=new HashMap<>();
        String path1=root+"/src/main/resources/templates/groupImg";
        File f=new File(path1);
        int num=0;
        if(f.isDirectory())
        {
            File flist[]=f.listFiles();
            num=flist.length+1;
        }
        String url="/templates/groupImg/"+num+".jpg";
        File fileStore=new File(root+"/src/main/resources/templates/groupImg",num+".jpg");
        try{file.transferTo(fileStore);}
        catch (Exception e){
            map.put("message","文件写入失败");
            map.put("errno",1);
            System.out.println("add picture flase"+url);
            return map;
        }
        System.out.println("add picture success");
        data.put("url",url);
        data.put("alt","picture");
        data.put("href",url);
        map.put("data",data);
        map.put("errno",0);
                return map;
    }

}
