package com.example.bookandmovie.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//次次递增
    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private String phone;

    /*public User(String username, String password){
        this.username = username;
        this.password = password;
    }*/
    public User(String username, String password, int op){
        if(op == 1)
            this.setEmail(username);
        else if(op == 2)
            this.setPhone(username);

        this.setPassword(password);
    }

    public User() {

    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
