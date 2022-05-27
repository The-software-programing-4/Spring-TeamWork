package com.example.bookandmovie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
    @GetMapping("/")
    public String Hello(){
        return "Hello!";
    }
}
