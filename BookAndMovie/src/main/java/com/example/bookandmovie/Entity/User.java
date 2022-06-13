package com.example.bookandmovie.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer s_id;
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    private String username;
    private String password;
    private String phone;
    private String email;
    private Date birthday;
      private String hometown1;
      private String hometown2;
        private String hometown3;
    private String livetown1;
    private String livetown2;
    private String livetown3;

    @Override
    public String toString() {
        return "User{" +
                "s_id=" + s_id +
                ", src='" + src + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", hometown1='" + hometown1 + '\'' +
                ", hometown2='" + hometown2 + '\'' +
                ", hometown3='" + hometown3 + '\'' +
                ", livetown1='" + livetown1 + '\'' +
                ", livetown2='" + livetown2 + '\'' +
                ", livetown3='" + livetown3 + '\'' +
                ", regionOP='" + regionOP + '\'' +
                ", birthOP='" + birthOP + '\'' +
                '}';
    }

    public Integer getS_id() {
        return s_id;
    }
    public User(String username, String password, int op){
        if(op == 1)
            this.setEmail(username);
        else if(op == 2)
            this.setPhone(username);

        this.setPassword(password);
    }
    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getHometown1() {
        return hometown1;
    }

    public void setHometown1(String hometown1) {
        this.hometown1 = hometown1;
    }

    public String getHometown2() {
        return hometown2;
    }

    public void setHometown2(String hometown2) {
        this.hometown2 = hometown2;
    }

    public String getHometown3() {
        return hometown3;
    }

    public void setHometown3(String hometown3) {
        this.hometown3 = hometown3;
    }

    public String getLivetown1() {
        return livetown1;
    }

    public void setLivetown1(String livetown1) {
        this.livetown1 = livetown1;
    }

    public String getLivetown2() {
        return livetown2;
    }

    public void setLivetown2(String livetown2) {
        this.livetown2 = livetown2;
    }

    private String regionOP;
      private String birthOP;

    public User(String username, String password)
    {
        this.username=username;
        this.password=password;
    }

    public User() {

    }

    public Integer get_id(){
        return s_id;
    }
    public void set_id(Integer s_id){
        this.s_id=s_id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
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
    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getRegionOP() {
        return regionOP;
    }

    public void setRegionOP(String regionOP) {
        this.regionOP = regionOP;
    }

    public String getBirthOP() {
        return birthOP;
    }

    public void setBirthOP(String birthOP) {
        this.birthOP = birthOP;
    }

    public String getLivetown3() {
        return livetown3;
    }

    public void setLivetown3(String livetown3) {
        this.livetown3 = livetown3;
    }
}
