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
}
