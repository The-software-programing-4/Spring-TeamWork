package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Post;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PostService {
    public void addPost(Post post);
    public Post findPost(int id);//适合通过id来获取帖子
    public int srcLength(int pid);
    public List<String> listSrc(int pid);
}
