package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormatJSP {
    @RequestMapping("/name")
    public String name(){
        return "name";
    }
}
