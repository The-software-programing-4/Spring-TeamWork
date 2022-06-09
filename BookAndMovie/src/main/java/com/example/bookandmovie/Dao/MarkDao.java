package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Mark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarkDao {
    public void addMark(Mark mark);
    public List<Mark> getMark(int type, int target);
    public void replyadd(int target);
    public int countMark_book(int target);
    public int countMark_movie(int target);
    public int culMark_book(int target,double score);
    public int culMark_movie(int target,double score);
    public Mark isthumb(int uid,int id);
    //添加 删除评论的方法
    public void deleteMark(int mid);
    public void dischange1(int target,int op,int uid);
    public void insertThumb(int target,int op,int uid);
    public void dropThumb(int target,int op,int uid);
    public void insertDisag(int target,int op,int uid);
    public void dropDisag(int target,int op,int uid);
    public void thumbChange1(int target,int op,int uid);
    public void dischange2(int target,int op,int uid);
    public void thumbChange2(int target,int op,int uid);
    public Mark isdis(int uid,int id);
}
