package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User selectUserByUsername(String username);
    User selectUserByUseremail(String email);
    User selectUserByUserphone(String phone);
    void registerUserByEmail(User user);
    void registerUserByPhone(User user);
}
