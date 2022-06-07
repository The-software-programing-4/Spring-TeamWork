package com.example.bookandmovie.Controller.Report;

import com.example.bookandmovie.Entity.Report;
import com.example.bookandmovie.Service.MarkService;
import com.example.bookandmovie.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private MarkService markService;//通过他来调用删除评论的方法
    @PostMapping("/api/report/addReport")
    public Map<String, Object> addReport(@RequestBody Map<String, Object> map){
        Map<String, Object> remap = new HashMap<>();
        Report report = new Report((int)map.get("mid"), (int)map.get("uid1"), (int)map.get("uid2"), (String) map.get("reason"), (String) map.get("type"), (String) map.get("content"));
        reportService.addReport(report);
        remap.put("message", "success");
        return remap;
    }

    @PostMapping("/api/report/listReport")
    public Map<String, Object> listReport(){
        Map<String, Object> map = new HashMap<>();
        List<Map> arr = new ArrayList<>();

        List<Report> reports = new ArrayList<>();
        reports = reportService.listReport();
        for(Report report : reports){
            Map<String, Object> temp = new HashMap<>();
            temp.put("rid", report.getRid());
            temp.put("mid", report.getMid());
            temp.put("uid1", report.getUid1());
            temp.put("uid2", report.getUid2());
            temp.put("content", report.getContent());
            temp.put("type", report.getType());
            temp.put("reason", report.getReason());
            arr.add(temp);
        }
        map.put("message", arr);
        return map;
    }

    @PostMapping("/api/report/solveReport")
    public Map<String, Object> solveReport(@RequestBody int mid, int op){
        Map<String, Object> map = new HashMap<>();
        if(op == 1){
            markService.deleteMark(mid);//举报成功就删除这条评论
        }
        reportService.solveReport(mid, op);
        map.put("success", true);
        return map;
    }
}
