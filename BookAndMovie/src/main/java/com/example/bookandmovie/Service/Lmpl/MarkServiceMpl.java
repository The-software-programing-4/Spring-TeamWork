package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.MarkDao;
import com.example.bookandmovie.Entity.Mark;
import com.example.bookandmovie.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServiceMpl implements MarkService {
    @Autowired
    private MarkDao markDao;
    @Override
    public void addMark(Mark mark){markDao.addMark(mark);}
    @Override
    public List<Mark> getMark(int type, int target){return markDao.getMark(type,target);}
    @Override
    public void replyadd(int target){markDao.replyadd(target);}
    @Override
    public void thumbChange(int target,int op,int uid){markDao.thumbChange(target, op,uid);}
    @Override
    public int countMark_book(int target){return markDao.countMark_book(target);}
    @Override
    public int countMark_movie(int target){return markDao.countMark_movie(target);}
    @Override
    public int culMark_book(int target,double score){return markDao.culMark_book(target,score);}
    @Override
    public int culMark_movie(int target,double score){return markDao.culMark_movie(target, score);}
    @Override
    public Mark isthumb(int uid,int id){return markDao.isthumb(uid,id);};
}
