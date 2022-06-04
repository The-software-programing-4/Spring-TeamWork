package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Topic;

import java.util.List;

public interface TopicService {
    public void addTopic(Topic topic);
    public Topic findTopic(int tid);
    public List<Topic> listTopic();
}
