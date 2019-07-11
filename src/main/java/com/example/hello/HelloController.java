package com.example.hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


// @Controller  返回模版 template

@RestController
public class HelloController {
    @RequestMapping("/home")
    public Map<String, Object> home() {
        Map<String, Object> userInfo = new HashMap<String, Object>();
        userInfo.put("name", "alex");
        userInfo.put("pwd", "12345678");
        return userInfo;
    }
    @RequestMapping("/")
    public String main(){
        return "HelloWorld";
    }
}
