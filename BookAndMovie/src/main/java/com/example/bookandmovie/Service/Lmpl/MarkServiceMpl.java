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
    public int countMark_book(int target){return markDao.countMark_book(target);}
    @Override
    public int countMark_movie(int target){return markDao.countMark_movie(target);}
    @Override
    public void culMark_book(int target,double score){ markDao.culMark_book(target,score);}
    @Override
    public void culMark_movie(int target,double score){markDao.culMark_movie(target, score);}
    @Override
    public Mark isthumb(int uid,int id){return markDao.isthumb(uid,id);}
    @Override
    public void deleteMark(int mid){markDao.deleteMark(mid);}
    public void dischange1(int target,int op,int uid){markDao.dischange1(target,op,uid);
    markDao.insertDisag(target, op, uid);};
    public void thumbChange1(int target,int op,int uid){markDao.thumbChange1(target, op,uid);
    markDao.insertThumb(target,op,uid);}
    public void dischange2(int target,int op,int uid){markDao.dischange2(target,op,uid);
    markDao.dropDisag(target, op, uid);};
    public void thumbChange2(int target,int op,int uid){markDao.thumbChange2(target, op,uid);
    markDao.dropThumb(target, op, uid);}
    public Mark isdis(int uid,int id){return markDao.isdis(uid, id);};
}
