package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.UserDao;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UserServiceLmpl implements UserSevice {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectUserByUsername(String username){
        return userDao.selectUserByUsername(username);
    }
    @Override
    public void registerNewUser(User user){
        userDao.registerNewUser(user);
    }
    @Override
    public User selectUserByEmail(String email){ return userDao.selectUserByEmail(email);}
    @Override
    public void insertUserImg(String username, byte[] photo) {
        userDao.insertUserImg(username,photo);
    }
    @Override
    public MultipartFile getUserImg(String username){return userDao.getUserImg(username);};
    public void updateUserMessage(User user){userDao.updateUserMessage(user);};
    @Override
    public void changPassword(String password, Integer uid){userDao.changPassword(password,uid);};
    @Override
    public User selectUserByUid(Integer uid){return userDao.selectUserByUid(uid);};
}
