package com.example.bookandmovie.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Post {//帖子 实体
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String src;//帖子的图片如何设计实体？
    private Date date;//发布时间
    private String content;//内容
    private Integer thumbs;//点赞数
    private Integer response;//回应
    private Integer transmit;//转发数

    //暂且不写set和get方法
}
