package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Discuss;
import com.example.bookandmovie.Entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscussDao {
    public void addDiscuss(Discuss discuss);
    public Discuss getDiscussById(int id);
    public List<Discuss> listDiscuss(int uid);
    public List<Group> listGroup(int uid);
}
