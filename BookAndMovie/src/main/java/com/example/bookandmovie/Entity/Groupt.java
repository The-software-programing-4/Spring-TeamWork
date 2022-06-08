package com.example.bookandmovie.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Groupt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//次次递增
    private int gid;

    private String name;
    private Date time;
    private String src;
    private int leader;
    private int number;
    private int response;
    @Lob
    private String introduction;

    public Groupt() {
    }

    public Groupt(String name, Date time, String src, int leader, int number, int response, String introduction) {
        this.name = name;
        this.time = time;
        this.src = src;
        this.leader = leader;
        this.number = number;
        this.response = response;
        this.introduction = introduction;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
