package com.example.bookandmovie.Service.Impl;

import com.example.bookandmovie.Dao.UserDao;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }
    /*@Override
    public void registerUser(User user){
        userDao.registerNewUser(user);
    }*/
    @Override
    public User selectUserByUseremail(String useremail){
        return userDao.selectUserByUseremail(useremail);
    }
    @Override
    public User selectUserByUserphone(String userphone){
        return userDao.selectUserByUserphone(userphone);
    }
    @Override
    public void registerUserByEmail(User user){
        userDao.registerUserByEmail(user);
    }
    @Override
    public void registerUserByPhone(User user){
        userDao.registerUserByPhone(user);
    }
}
