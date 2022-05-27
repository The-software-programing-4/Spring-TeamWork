package com.example.bookandmovie.Controller.Book;

import com.example.bookandmovie.Entity.Book;
import com.example.bookandmovie.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/api/book/message_get")
    public Map<String, Object> message_get(@RequestBody String bookname){//按照bookname来搜索
        Map<String, Object> map = new HashMap<>();
        try{
            Book book1 = bookService.selectBookByBookname(bookname);
            if(book1 == null){
                map.put("success", false);
                map.put("message", "未找到该图书！");
            }
            else{
                map.put("book_id", book1.getBook_id());
                map.put("author", book1.getAuthor());
                map.put("binding", book1.getBinding());
                map.put("brief_introduction", book1.getBrief_introduction());
                map.put("directory", book1.getDirectory());
                map.put("brief_introduction_of_author", book1.getBrief_introduction_of_author());
                map.put("isbn", book1.getISBN());
                map.put("origin_name", book1.getOrigin_name());
                map.put("pages_number", book1.getPages_number());
                map.put("press", book1.getPress());
                map.put("price", book1.getPrice());
                map.put("producer", book1.getProducer());
                map.put("promoting", book1.getPromoting());
                map.put("publish_date", book1.getPublish_date());
                map.put("translater", book1.getTranslator());

                map.put("success", true);
                map.put("message", "已找到该图书！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "异常错误！");
        }
        return map;
    }

    @PostMapping("/api/book/message_set")
    public Map<String, Object> message_set(@RequestBody Map<String, Object> re_map){
        Map<String, Object> map = new HashMap<>();
        Integer book_id, pages_number, ISBN;
        String bookname, author, press, producer, origin_name, translator, binding, brief_introduction, promoting,brief_introduction_of_author, directory;
        try{
            Book book1 = bookService.selectBookByBookname(bookname);
        }catch (Exception e){

        }
        return map;
    }
}
