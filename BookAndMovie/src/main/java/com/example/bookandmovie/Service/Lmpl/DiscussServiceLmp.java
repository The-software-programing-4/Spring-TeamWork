package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.DiscussDao;
import com.example.bookandmovie.Entity.Discuss;
import com.example.bookandmovie.Service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscussServiceLmp implements DiscussService {
    @Autowired
    private DiscussDao discussDao;
    public void addDiscuss(Discuss discuss){discussDao.addDiscuss(discuss);};
    public Discuss getDiscussById(int id){return discussDao.getDiscussById(id);};
}
