package com.example.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetError {
    @RequestMapping("/number")
    public String number(){
        int i = 1/0;
        return "error";
    }
}
