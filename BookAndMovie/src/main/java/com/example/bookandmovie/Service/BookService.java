package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Book;

import java.util.List;

public interface BookService {
    Book selectBookByBookname(String bookname);
    Book selectBookByBook_id(Integer book_id);
    Book selectBookByBookISBN(String ISBN);
    void insertBook(Book book);
    List listBook();
}
