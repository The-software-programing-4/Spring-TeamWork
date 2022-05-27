package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Book;

public interface BookService {
    Book selectBookByBookname(String bookname);
}
