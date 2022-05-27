package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao {
    Book selectBookByBookname(String bookname);
    Book selectBookByBook_id(Integer book_id);
    Book selectBookByBookISBN(Integer ISBN);
    void insertBook(Book book);
}
