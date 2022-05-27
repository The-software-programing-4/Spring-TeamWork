package com.example.bookandmovie.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;
    private String src;
    private String name;
    private String actors;
    private String directors;
    private String writers;
    private String category;
    private String language;
    private int length;
    private Date date;
    private String position;
    private String IMDb;
    private double score;
    @Lob
    private String brief_introduction;//内容简介
    public Movie(){
        name=null;
    }

    public Movie(int mid, String src, String name, String actors, String directors, String writers, String category, String language, int length, Date date, String position, String IMDb, double score, String brief_introduction) {
        this.mid = mid;
        this.src = src;
        this.name = name;
        this.actors = actors;
        this.directors = directors;
        this.writers = writers;
        this.category = category;
        this.language = language;
        this.length = length;
        this.date = date;
        this.position = position;
        this.IMDb = IMDb;
        this.score = score;
        this.brief_introduction = brief_introduction;
    }



    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIMDb() {
        return IMDb;
    }

    public void setIMDb(String IMDb) {
        this.IMDb = IMDb;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getBrief_introduction() {
        return brief_introduction;
    }

    public void setBrief_introduction(String brief_introduction) {
        this.brief_introduction = brief_introduction;
    }
}
