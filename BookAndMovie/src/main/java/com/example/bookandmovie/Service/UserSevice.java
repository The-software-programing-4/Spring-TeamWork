package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UserSevice {
    public User selectUserByUsername(String username);
    public User selectUserByEmail(String email);
    public void registerNewUser(User user);
    public void insertUserImg(String username, byte[] photo);
    public MultipartFile getUserImg(String username);
    public void updateUserMessage(User user);
    public void changPassword(String password, Integer uid);
    public User selectUserByUid(Integer uid);
}
