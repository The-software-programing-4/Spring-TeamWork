package com.example.bookandmovie.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.ArrayList;

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topic_id;
    //topic_id 为自增的主键
    private Integer focus;//关注数量

    @Lob
    private String introduction;//简介

    //接下来展示所属的帖子
    private ArrayList<Integer> post_arr = new ArrayList<>();//储存所有属于该话题的帖子ID

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
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

    public ArrayList<Integer> getPost_arr() {
        return post_arr;
    }

    public void setPost_arr(ArrayList<Integer> post_arr) {
        this.post_arr = post_arr;
    }
}
