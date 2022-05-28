package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    Book selectBookByBookname(String bookname);
    Book selectBookByBook_id(Integer book_id);
    Book selectBookByBookISBN(String ISBN);
    void insertBook(Book book);
    List listBook();
}
