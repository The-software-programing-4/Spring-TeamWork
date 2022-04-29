package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.UserDao;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
