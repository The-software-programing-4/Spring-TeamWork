package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostDao {
    public void addPost(Post post);
    public Post findPost(int pid);
    public int srcLength(int pid);
    public List<String> listSrc(int pid);
}
