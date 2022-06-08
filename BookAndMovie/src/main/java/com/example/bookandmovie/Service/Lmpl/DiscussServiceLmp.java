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
    public void totop(int id){discussDao.totop(id);};
    @Override
    public void notop(int id){discussDao.notop(id);};
    public void delet(int id){discussDao.delet(id);};
    public List<Groupt> findGroupUidInManage(int uid){return discussDao.findGroupUidInManage(uid);};
    public void setmanage(int uid,int gid,int role){discussDao.setmanage(uid,gid,role);};
    public List<User> findMemberByGid1(int gid){return discussDao.findMemberByGid1(gid);};
    public List<User> findMemberByGid2(int gid){return discussDao.findMemberByGid2(gid);};
    public void tostar(int id){discussDao.tostar(id);};
    public void nostar(int id){discussDao.nostar(id);};
    public void tomanager(int uid,int gid){discussDao.tomanager(uid,gid);};
    public List<User> findMemberByGid0(int gid){return discussDao.findMemberByGid0(gid);};
    public List<Discuss> listDiscussT(int tid){return discussDao.listDiscussT(tid);};
    public void addGroup(Groupt groupt){discussDao.addGroup(groupt);};
    public void addLeader(User user){discussDao.addLeader(user);};
    public void addLeader2(User user){discussDao.addLeader2(user);};
    public void addGroupPic(String src,int gid){discussDao.addGroupPic(src,gid);}
}
