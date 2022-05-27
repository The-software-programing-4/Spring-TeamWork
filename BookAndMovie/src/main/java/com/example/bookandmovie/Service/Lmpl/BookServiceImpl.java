package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.BookDao;
import com.example.bookandmovie.Entity.Book;
import com.example.bookandmovie.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Book selectBookByBookname(String bookname){
        return bookDao.selectBookByBookname(bookname);
    }

}
