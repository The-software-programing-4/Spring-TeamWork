package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.DiscussDao;
import com.example.bookandmovie.Entity.Discuss;
import com.example.bookandmovie.Entity.Groupt;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceLmp implements DiscussService {
    @Autowired
    private DiscussDao discussDao;
    public void addDiscuss(Discuss discuss){discussDao.addDiscuss(discuss);};
    public Discuss getDiscussById(int id){return discussDao.getDiscussById(id);};
    public List<Discuss> listDiscussU(int uid){return discussDao.listDiscussU(uid);};
    public List<Discuss> listDiscussG(int gid){return discussDao.listDiscussG(gid);};
    public Groupt findGroupByGid(int gid){return discussDao.findGroupByGid(gid);};
    public List<Groupt> findGroupUidIn(int uid){return discussDao.findGroupUidIn(uid);};
    public List<User> findMemberByGid(int gid){return discussDao.findMemberByGid(gid);}
    public User findIfUserInGroup(int uid,int gid){return discussDao.findIfUserInGroup(uid,gid);};
    public  List<Groupt> findGroupAll(){return discussDao.findGroupAll();};
    public void addIntoGroup(int uid,int gid,int role){discussDao.addIntoGroup(uid,gid,role);};
    public void dropFromGroup(int uid,int gid){discussDao.dropFromGroup(uid,gid);};
}
