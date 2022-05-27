package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;

@Mapper
public interface UserDao {
    public User selectUserByUsername(String username);
    public User selectUserByEmail(String email);
    User selectUserByPhone(String phone);
    public User selectUserByUid(Integer uid);
    public void registerNewUser(User user);
    public void updateUserMessage(User user);
    public void changPassword(String password, Integer uid);
    void registerUserByEmail(User user);
    void registerUserByPhone(User user);
}
