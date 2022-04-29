package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.User;

public interface UserSevice {
    public User selectUserByUsername(String username);
    public User selectUserByEmail(String email);
    public void registerNewUser(User user);

}
