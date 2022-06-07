package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Discuss;
import com.example.bookandmovie.Entity.Groupt;
import com.example.bookandmovie.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscussDao {
    public void addDiscuss(Discuss discuss);
    public Discuss getDiscussById(int id);
    public List<Discuss> listDiscussU(int uid);
    public List<Discuss> listDiscussG(int gid);
    public Groupt findGroupByGid(int gid);
    public List<Groupt> findGroupUidIn(int uid);
    public List<User> findMemberByGid(int gid);
    public User findIfUserInGroup(int uid,int gid);
    public  List<Groupt> findGroupAll();
    public void addIntoGroup(int uid,int gid,int role);
    public void dropFromGroup(int uid,int gid);
    public void totop(int id);
    public void notop(int id);
    public void delet(int id);
    public void tostar(int id);
    public void nostar(int id);
    public void setmanage(int uid,int gid,int role);
    public List<User> findMemberByGid1(int gid);
    public List<User> findMemberByGid2(int gid);
    public List<Groupt> findGroupUidInManage(int uid);
    public void tomanager(int uid,int gid);
    public List<User> findMemberByGid0(int gid);
}
