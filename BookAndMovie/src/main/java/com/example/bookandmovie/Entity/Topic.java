package com.example.bookandmovie.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.ArrayList;

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    //topic_id 为自增的主键
    private Integer focus;//关注数量

    private Integer num;//表示一共有多少个帖子

    @Lob
    private String introduction;//简介

    private String name;

    //接下来展示所属的帖子
    //private ArrayList<Integer> post_arr = new ArrayList<>();//储存所有属于该话题的帖子ID 这个不需要在Java类中进行操作
    //使用关系数据库为其创建一份新的表 关系对应为 Topic.ID---Post.ID

    public Topic(){};
    public Topic(int tid, int focus, int num, String introduction, String name){
        this.tid = tid;
        this.focus= focus;
        this.num = num;
        this.introduction = introduction;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
