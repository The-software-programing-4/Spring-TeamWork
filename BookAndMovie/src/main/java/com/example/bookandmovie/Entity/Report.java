package com.example.bookandmovie.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rid;//主键 表示举报信息的id

    int mid, uid1, uid2;//分别表示 mark的id， 举报者的id， 被举报者的id
    String reason, type, content;

    public Report(){};
    public Report(int mid, int uid1, int uid2, String reason, String type, String content){
//        this.rid = rid;
        this.mid = mid;
        this.uid1 = uid1;
        this.uid2 =uid2;
        this.reason = reason;
        this.type = type;
        this.content = content;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getUid1() {
        return uid1;
    }

    public void setUid1(int uid1) {
        this.uid1 = uid1;
    }

    public int getUid2() {
        return uid2;
    }

    public void setUid2(int uid2) {
        this.uid2 = uid2;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
