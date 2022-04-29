package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User selectUserByUsername(String username);
    public User selectUserByEmail(String email);
    public void registerNewUser(User user);
}
