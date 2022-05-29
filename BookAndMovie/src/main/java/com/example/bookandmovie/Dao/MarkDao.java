package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Mark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarkDao {
    public void addMark(Mark mark);
    public List<Mark> getMark(int type, int target);
    public void replyadd(int target);
    public void thumbChange(int target,int op,int uid);
    public int countMark_book(int target);
    public int countMark_movie(int target);
    public int culMark_book(int target,double score);
    public int culMark_movie(int target,double score);
    public Mark isthumb(int uid,int id);
}
