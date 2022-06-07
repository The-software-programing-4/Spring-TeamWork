package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportDao {
    public void addReport(Report report);
    public List<Report> listReport();
    public void solveReport(int mid, int op);//mid用来查找你要处理的评论 op=0：表示该评论的举报失败，清除所有该评论的举报信息
    //op=2 表示该评论被举报成功 清除该评论 并且清除相应的举报信息
}
