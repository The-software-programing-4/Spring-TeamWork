package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.User;

public interface UserService {
    User selectUserByUsername(String username);
    User selectUserByUseremail(String useremail);
    User selectUserByUserphone(String userphone);
    void registerUserByEmail(User user);
    void registerUserByPhone(User user);
}
