package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Topic;

public interface TopicService {
    public void addTopic(Topic topic);
    public Topic findTopic(int tid);
}
