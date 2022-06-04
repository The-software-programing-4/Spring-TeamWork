package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.TopicDao;
import com.example.bookandmovie.Entity.Topic;
import com.example.bookandmovie.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;
    @Override
    public void addTopic(Topic topic){topicDao.addTopic(topic);}
    @Override
    public Topic findTopic(int tid){return topicDao.findTopic(tid);}
}
