package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//返回模范template
@Controller
public class FormatTemplate {
    @RequestMapping("/index")
    public String index(Map<String, Object> result){
        System.out.println("index...... ");

        result.put("name", "wusir");
        result.put("sex", 1);

        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        result.put("userList", list);
        // 返回的页面
        return "index";
    }
}
