package com.example.bookandmovie.Entity;

import java.util.Date;

public class Mark {
    private int id;
    private int type;
    private int target;
    private int uid;

    private String content;
    private double score;
    private Date day;

    private int thumb;
    private int reply;

    public Mark() {
    }

    public Mark(int id, int type, int target, int uid, String content, double score, Date day, int thumb, int reply) {
        this.id = id;
        this.type = type;
        this.target = target;
        this.uid = uid;
        this.content = content;
        this.score = score;
        this.day = day;
        this.thumb = thumb;
        this.reply = reply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }
}
