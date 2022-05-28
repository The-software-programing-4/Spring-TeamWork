package com.example.bookandmovie.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topic_id;
    //topic_id 为自增的主键
    private Integer focus;//关注数量
    @Lob
    private String introduction;//简介

    //接下来展示所属的帖子
}
