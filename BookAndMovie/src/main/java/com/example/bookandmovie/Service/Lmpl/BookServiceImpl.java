package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.BookDao;
import com.example.bookandmovie.Entity.Book;
import com.example.bookandmovie.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Book selectBookByBookname(String bookname){
        return bookDao.selectBookByBookname(bookname);
    }
    @Override
    public Book selectBookByBook_id(Integer book_id) {return bookDao.selectBookByBook_id(book_id);}
    @Override
    public Book selectBookByBookISBN(String ISBN) {return bookDao.selectBookByBookISBN(ISBN);}
    @Override
    public void insertBook(Book book){bookDao.insertBook(book);}
    @Override
    public List listBook(){return bookDao.listBook();}
}
