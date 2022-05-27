package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Book;

public interface BookService {
    Book selectBookByBookname(String bookname);
    Book selectBookByBook_id(Integer book_id);
    Book selectBookByBookISBN(Integer ISBN);
    void insertBook(Book book);
}
