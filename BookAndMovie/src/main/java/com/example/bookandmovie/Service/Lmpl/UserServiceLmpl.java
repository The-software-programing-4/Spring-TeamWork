package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.UserDao;
import com.example.bookandmovie.Entity.User;
import com.example.bookandmovie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceLmpl implements UserService {
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
    public void updateUserMessage(User user){userDao.updateUserMessage(user);}
    @Override
    public void changPassword(String password, Integer uid){userDao.changPassword(password,uid);}
    @Override
    public User selectUserByUid(Integer uid){return userDao.selectUserByUid(uid);}
    @Override
    public User selectUserByPhone(String phone){return userDao.selectUserByPhone(phone);}
    @Override
    public void registerUserByEmail(User user){ userDao.registerUserByEmail(user);}
    @Override
    public void registerUserByPhone(User user){ userDao.registerUserByPhone(user);}
    public void addImg(String url,int uid){userDao.addImg(url,uid);};
}
