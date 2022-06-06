package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Topic;

import java.util.List;

public interface TopicService {
    public void addTopic(Topic topic);
    public Topic findTopic(int tid);
    public List<Topic> listTopic();
    public List<Integer> listPid(int tid);//从附加的表里面查询对应的pid
    public int pidLength(int tid);
}
