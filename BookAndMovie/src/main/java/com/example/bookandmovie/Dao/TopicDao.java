package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Topic;
import com.example.bookandmovie.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.Entity;
import java.util.List;

@Mapper
public interface TopicDao {
    public void addTopic(Topic topic);
    public Topic findTopic(int tid);//用id来寻找对应话题
    public List<Topic> listTopic();
    public List<Integer> listPid(int tid);
    public int pidLength(int tid);
    public void addConcern(int uid,int tid);
    public void dropConcern(int uid,int tid);
    public User checkConcern(int uid, int tid);
}
