package com.example.bookandmovie.Controller.Book;

import com.example.bookandmovie.Controller.EditDistance;
import com.example.bookandmovie.Entity.Book;
import com.example.bookandmovie.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    //此处设置上传图片的链接 以及图片保存的url前缀
    //这是本地存入的格式，上传到服务器的话，格式类似于，"/root/images/pc/"
    private static String DOWNLOAD_FOLDER = "BookAndMovie/src/main/resources/templates/bookImg";
    //

    @PostMapping("/api/book/message_get")
    public Map<String, Object> message_get(@RequestBody int bookid){//按照bookid来搜索
        Map<String, Object> map = new HashMap<>();
        try{
            Book book1 = bookService.selectBookByBook_id(bookid);
            if(book1 == null){
                map.put("success", false);
                map.put("message", "未找到该图书！");
            }
            else{
                map.put("book_id", book1.getBook_id());
                map.put("src",book1.getSrc());
                map.put("bookname",book1.getBookname());
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
                map.put("translator", book1.getTranslator());

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
        Integer book_id, pages_number;
        String ISBN, bookname, author, press, producer, origin_name, translator, binding, brief_introduction, promoting,brief_introduction_of_author, directory;
        double price;
        Date publish_date;
        book_id =(Integer) re_map.get("book_id");
        ISBN = (String) re_map.get("ISBN");
        try{
            Book book1 = bookService.selectBookByBook_id(book_id);
            Book book2 = bookService.selectBookByBookISBN(ISBN);
            if(book1 != null){
                map.put("success", false);
                map.put("message", "该图书ID已存在！");
            }
            else if(book2 != null){
                map.put("success", false);
                map.put("message", "该图书ISBN已存在！");
            }else {
                Book book3 = new Book();
                book3.setBook_id(book_id);
                book3.setBookname((String) re_map.get("bookname"));
                book3.setAuthor((String) re_map.get("author"));
                book3.setBinding((String) re_map.get("binding"));
                book3.setDirectory((String) re_map.get("directory"));
                book3.setISBN((String) re_map.get("ISBN"));
                book3.setBrief_introduction((String) re_map.get("brief_introduction"));
                book3.setBrief_introduction_of_author((String) re_map.get("brief_introduction_of_author"));
                book3.setOrigin_name((String) re_map.get("origin_name"));
                book3.setPages_number((Integer) re_map.get("pages_number"));
                book3.setPress((String) re_map.get("press"));
                book3.setPrice((double) re_map.get("price"));
                book3.setProducer((String) re_map.get("producer"));
                book3.setPromoting((String) re_map.get("promoting"));
                book3.setPublish_date((Date) re_map.get("publish_date"));
                book3.setTranslator((String) re_map.get("translator"));
                bookService.insertBook(book3);//
                map.put("success", true);
                map.put("message", "图书插入成功");
            }
        }catch (Exception e){
            map.put("success", false);
            map.put("message", "图书插入出现异常！");
        }

        return map;
    }

    @PostMapping("api/book/listBook")
    public Map<String, Object> listBook(){//选取十本最受好评的图书
        List<Book> books = bookService.listBook();
        Map<String, Object> remap = new HashMap<>();
        int i = 1;
        List<Map> arr = new ArrayList<>();
        System.out.println(books.toString());
        for(Book book:books){
            Map<String, Object> map_temp = new HashMap<>();
            map_temp.put("book_id",book.getBook_id());
            map_temp.put("name", book.getBookname());
            map_temp.put("src", book.getSrc());
            map_temp.put("author", book.getAuthor());
            map_temp.put("score", book.getScore());
            arr.add(map_temp);
            i++;
            if(i>10) break;
        }
        remap.put("messages", arr);
        return remap;
    }

    @PostMapping("api/book/insertImg")
    public Map<String, Object> insertImg(@RequestBody String ISBN, String img_location){//此方法可用来远程处理图片链接
        Map<String, Object> map = new HashMap<>();
        try{
            Book book1 = bookService.selectBookByBookISBN(ISBN);
            if(book1 == null){
                map.put("success", false);
                map.put("message", "未找到该图书！");
            }else{
                map.put("book_id", book1.getBook_id());
                map.put("bookname", book1.getBookname());//简要返回找到的书籍的信息
                if(book1.getSrc() == null)
                {
                    book1.setSrc(img_location);//将图书的图片链接设定
                    map.put("success", true);
                    map.put("message", "该图书图片设定成功！");
                }else {
                    book1.setSrc(img_location);
                    map.put("success", true);
                    map.put("message", "该图书图片更新成功！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "图片设置出现异常错误！");
        }
        return map;
    }
    /*
    @PostMapping("api/book/downloadImg")
    public Map<String, Object> downloadImg(MultipartFile target){
        Map<String, Object> map = new HashMap<>();
        if(Objects.isNull(target) || target.isEmpty()){
            map.put("success", false);
            map.put("message", "文件为空，请重新上传");
            return map;
        }
        try{
            byte[] bytes = target.getBytes();
            //要存入本地的地址放到path里面
            Path path = Paths.get(DOWNLOAD_FOLDER+"/");
            //获取文件的后缀名
            String extension = target.getOriginalFilename().substring(target.getOriginalFilename().lastIndexOf("."));
            UUID uuid = UUID.randomUUID();//调用UUID获取全宇宙唯一的真名
            String str = uuid.toString();
            String imgName = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
            //去掉了uuid中看起来不顺眼的"-"
            String relativeAddr = imgName + extension;//唯一的名字接上后缀
            File saveFile = new File(relativeAddr);
            target.transferTo(saveFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    */

    @PostMapping("/api/book/uploadImg")
    public String uploadImg(HttpSession session, @RequestBody MultipartFile file, String bookname){
        String root=System.getProperty("user.dir");
        Book book = bookService.selectBookByBookname(bookname);

        if(bookname==null || book==null)
            return "图书不存在！";
        String path = root + "/src/main/resources/templates/bookImg" + bookname + ".jpg";
        File fileEx1 = new File(path);
        if(fileEx1.exists()){
            fileEx1.delete();
        }
        File fileStore = new File(root + "/src/main/resources/templates/bookImg" + bookname + ".jpg");
        try{
            file.transferTo(fileStore);
        }catch (Exception e){
            return "文件写入失败";
        }
        return "Upload file success : " + file.getOriginalFilename();
    }

    /*@PostMapping("api/book/getImg")
    public Map<String, Object> getImg(@RequestBody String ISBN){
        Map<String, Object> map = new HashMap<>();
        try{
            Book book1 = bookService.selectBookByBookISBN(ISBN);
            if(book1 == null){
                map.put("success", false);
                map.put("message", "未找到该图书！");
            }else {
                map.put("book_id", book1.getBook_id());
                map.put("bookname", book1.getBookname());//简要返回找到的书籍的信息
                String src = book1.getSrc();
                if(src == null){
                    map.put("success", false);
                    map.put("message", "该图书图片为空！");
                }else{
                    map.put("success", true);
                    map.put("message", "成功获取该图书图片");
                    map.put("src", src);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "图片获取出现异常错误！");
        }
        return map;
    }
    */

    @GetMapping("api/book/getImg")
    @ResponseBody
    public Map<String,Object> getImg(HttpSession session)
    {
        String bookname = (String) session.getAttribute("bookname");
        Map<String,Object> map = new HashMap<>();
        Book book = bookService.selectBookByBookname(bookname);
        if(bookname==null || book == null)
        {
            map.put("bookname",bookname);
            map.put("message","图书在数据库中不存在");
            return map;
        }
        System.out.println("开始获取图书图片"+bookname);
        String root=System.getProperty("user.dir");
        String path1=root+"/src/main/resources/templates/bookImg/"+bookname+".jpg";
        File file1=new File(path1);
        if(file1.exists())
        {
            map.put("bookname",bookname);
            map.put("message", "template/bookImg" + bookname + ".jpg");
            return map;
        }
        else{
            map.put("bookname",bookname);
            map.put("message","图书不存在");
            return map;
        }
    }

    @PostMapping("/api/book/booksearch")
    public Map<String, Object> searchBook(@RequestBody String key)
    {
        List<Book> books= bookService.listBook();
        Map<String, Object> remap=new HashMap<>();
        List<Map> arr=new ArrayList<>();
        EditDistance editDistance=new EditDistance();
        int editD;
        for(Book b:books)
        {
            editD=editDistance.solve(b.getBookname(),key);
            if(editD<b.getBookname().length())
            {
                Map<String,Object> map_temp=new HashMap<>();
                map_temp.put("bookname",b.getBookname());
                map_temp.put("src", b.getSrc());
                map_temp.put("book_id", b.getBook_id());
                map_temp.put("score", b.getScore());
                map_temp.put("author", b.getAuthor());
                map_temp.put("press", b.getPress());
                arr.add(map_temp);
            }
        }
        remap.put("messages",arr);
        return remap;
    }
}
