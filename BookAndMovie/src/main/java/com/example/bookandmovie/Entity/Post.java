package com.example.bookandmovie.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//帖子的图片 在上传帖子时 前端给后端发送图片对应的id(均为数字 暂不考虑重复图片的情况) 之后由后端将数字转换为地址 方便前端取出图片
public class Post {//帖子 实体
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;//主键

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    private String username;
    private String src;
    private Integer length;//图片数量
    private Date date;//发布时间
    private String content;//内容
    private Integer thumbs;//点赞数
    private Integer response;//回应
    private Integer transmit;//转发数

    public Post(){}
    public Post(int pid, String src, String username, String content, Integer thumbs, Integer response, Integer transmit, Date date, Integer length){
        this.username = username;
        this.transmit= transmit;
        this.src = src;
        this.response = response;
        this.pid = pid;
        this.date = date;
        this.thumbs = thumbs;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getThumbs() {
        return thumbs;
    }

    public void setThumbs(Integer thumbs) {
        this.thumbs = thumbs;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public Integer getTransmit() {
        return transmit;
    }

    public void setTransmit(Integer transmit) {
        this.transmit = transmit;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
