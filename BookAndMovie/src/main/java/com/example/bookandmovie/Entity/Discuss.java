package com.example.bookandmovie.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Discuss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//次次递增
    private int id;
    private int uid;
    private int gid;
    private int tid;
    @Lob
    private String content;
    private String title;
    private int thumb;
    private int respose;
    private Date time;
    private int top;
    private int star;

    public int getStar() {
        return star;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Discuss() {
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public Discuss(int uid, int gid, String content, String title, int thumb, int respose, Date time) {
        this.uid = uid;
        this.gid = gid;
        this.content = content;
        this.title = title;
        this.thumb = thumb;
        this.respose = respose;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public int getRespose() {
        return respose;
    }

    public void setRespose(int respose) {
        this.respose = respose;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
