package com.example.bookandmovie.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer s_id;

    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private Date birthday;
      private String province;
      private String city;
    private String homeProvince;
    private String cityProvince;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCityProvince() {
        return cityProvince;
    }

    public String getHomeProvince() {
        return homeProvince;
    }

    public void setCityProvince(String cityProvice) {
        this.cityProvince = cityProvice;
    }

    public void setHomeProvince(String homeProvince) {
        this.homeProvince = homeProvince;
    }
}
