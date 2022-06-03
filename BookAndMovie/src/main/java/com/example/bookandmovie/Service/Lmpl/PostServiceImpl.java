package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.PostDao;
import com.example.bookandmovie.Entity.Post;
import com.example.bookandmovie.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;
    @Override
    public void addPost(Post post){postDao.addPost(post);}
    @Override
    public Post findPost(int pid){return postDao.findPost(pid);}
}
