package com.example.hello;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller  返回模版 template
@SpringBootApplication
//扫包
@ComponentScan(basePackages = {"com.example.Controller", "service","com.example.hello", "redis.service"})
@MapperScan(basePackages = {"mapper", "test01.dao", "test02.dao"})
//加上定时任务
//@EnableScheduling
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
