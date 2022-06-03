package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostDao {
    public void addPost(Post post);
    public Post findPost(int pid);
}
