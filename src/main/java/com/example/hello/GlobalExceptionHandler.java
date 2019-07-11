package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//全局捕获异常
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    //拦截异常
    @ExceptionHandler(RuntimeException.class)
    //响应体json
    @ResponseBody
    public Map<String, Object> resultError(){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("errorCode", "500");
        resultMap.put("errorMsg", "系统错误");
        return resultMap;
    }
}
