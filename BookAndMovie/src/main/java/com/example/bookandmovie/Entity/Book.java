package com.example.bookandmovie.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//次次递增
    private Integer book_id;

    private String bookname;
    private String author;
    private String press;//出版社
    private String producer;//出品方
    private String origin_name;//原作名
    private String translator;
    private Date publish_date;//出版时间 是否需要使用date类
    private Integer pages_number;//页数
    private Double price;//定价
    private String binding;//装帧
    private Integer ISBN;
    @Lob
    private String brief_introduction;//内容简介
    @Lob
    private String promoting;//名家推荐
    @Lob
    private String brief_introduction_of_author;//作者简介
    @Lob
    private String directory;//目录

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getPages_number() {
        return pages_number;
    }

    public void setPages_number(Integer pages_number) {
        this.pages_number = pages_number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getBrief_introduction() {
        return brief_introduction;
    }

    public void setBrief_introduction(String brief_introduction) {
        this.brief_introduction = brief_introduction;
    }

    public String getPromoting() {
        return promoting;
    }

    public void setPromoting(String promoting) {
        this.promoting = promoting;
    }

    public String getBrief_introduction_of_author() {
        return brief_introduction_of_author;
    }

    public void setBrief_introduction_of_author(String brief_introduction_of_author) {
        this.brief_introduction_of_author = brief_introduction_of_author;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
