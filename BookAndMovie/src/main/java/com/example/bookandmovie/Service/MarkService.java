package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Mark;
import org.hibernate.dialect.MariaDB10Dialect;

import java.util.List;

public interface MarkService {
    public void addMark(Mark mark);
    public List<Mark> getMark(int type, int target);
    public void replyadd(int target);
    public void thumbChange(int target,int op);
    public int countMark_book(int target);
    public int countMark_movie(int target);
    public int culMark_book(int target,double score);
    public int culMark_movie(int target,double score);
}
