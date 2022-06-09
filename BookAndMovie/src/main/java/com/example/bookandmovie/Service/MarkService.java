package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Mark;
import org.hibernate.dialect.MariaDB10Dialect;

import java.util.List;

public interface MarkService {
    public void addMark(Mark mark);
    public List<Mark> getMark(int type, int target);
    public void replyadd(int target);

    public int countMark_book(int target);
    public int countMark_movie(int target);
    public void culMark_book(int target,double score);
    public void culMark_movie(int target,double score);
    public Mark isthumb(int uid,int id);
    public Mark isdis(int uid,int id);
    public void deleteMark(int mid);
    public void dischange1(int target,int op,int uid);
    public void thumbChange1(int target,int op,int uid);
    public void dischange2(int target,int op,int uid);
    public void thumbChange2(int target,int op,int uid);
}
