package com.example.Controller;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.service.RedisService;
import service.UserService;
import test01.dao.UserMapperTest01;
import test02.dao.UserMapperTest02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapperTest01 userMapperTest01;

    @Autowired
    private UserMapperTest02 userMapperTest02;

    @Autowired
    private RedisService redisService;


    @RequestMapping("/createUser")
    public String createUser(String name){
        System.out.println("到这里了嫩");
        userService.createUser(name);
        return "success";
    }

    @RequestMapping("/find")
    public Integer find(){
        Integer meg = userService.findAllCount();
        return meg;
    }

    @ResponseBody
    @RequestMapping("/findByName")
    public User findByName(String name){
        return userMapper.findByName(name);
    }

    @RequestMapping("/insert")
    public String insert(String name){
        userMapper.insert(name);
        return "success";
    }

    @RequestMapping("/insertTest")
    //事务回滚
    @Transactional
    public String insertTest(String name){
        userMapper.insert(name);
        int i = 1/0;
        return "success";
    }

    @RequestMapping("/getMessage")
    public List<Object> getMessage(){
//        Map<String, Object> message = new HashMap<String, Object>();
        System.out.println("================================================");
        List<User> getMessage = userMapper.findAll();
        List<Object> userList = new ArrayList<Object>();
        for(User item: getMessage){
            Map<String, Object> message = new HashMap<String, Object>();
            message.put("id", item.getId());
            message.put("name", item.getName());
//            System.out.println(message);
            userList.add(message);
        }
        return userList;
    }

    @RequestMapping("/insertTest01")
    public String insertTest01(String name){
        userMapperTest01.insert(name);
        return "success";
    }

    @RequestMapping("/insertTest02")
    public String insertTest02(String name){
        userMapperTest02.insert(name);
        return "success";
    }

    @RequestMapping("/setString")
    public String setString(String key, String value){
        redisService.setString(key, value);
        return "success";
    }

    @RequestMapping("/setList")
    public String setList(String key){
        List<String> listString = new ArrayList<String>();
        listString.add("123");
        listString.add("456");
        redisService.setList(key, listString);
        return "success";
    }
    @RequestMapping("/getKey")
    public String getKey(String key){
        return redisService.getStringKey(key);
    }
}
