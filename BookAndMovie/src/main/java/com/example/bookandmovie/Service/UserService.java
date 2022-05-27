package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    public User selectUserByUsername(String username);
    public User selectUserByEmail(String email);
    public User selectUserByPhone(String phone);
    public void registerNewUser(User user);
    public void updateUserMessage(User user);
    public void changPassword(String password, Integer uid);
    public User selectUserByUid(Integer uid);
    public void registerUserByEmail(User user);
    public void registerUserByPhone(User user);
}
