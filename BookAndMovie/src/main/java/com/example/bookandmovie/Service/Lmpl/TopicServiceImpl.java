package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.TopicDao;
import com.example.bookandmovie.Entity.Topic;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;
    @Override
    public void addTopic(Topic topic){topicDao.addTopic(topic);}
    @Override
    public Topic findTopic(int tid){return topicDao.findTopic(tid);}
    @Override
    public List<Topic> listTopic(){return topicDao.listTopic();}
    @Override
    public List<Integer> listPid(int tid){return topicDao.listPid(tid);}
    @Override
    public int pidLength(int tid){return topicDao.pidLength(tid);}
    public void addConcern(int uid,int tid){topicDao.addConcern(uid,tid);};
    public void dropConcern(int uid,int tid){topicDao.dropConcern(uid,tid);};
    public User checkConcern(int uid, int tid){return topicDao.checkConcern(uid,tid);};
}
