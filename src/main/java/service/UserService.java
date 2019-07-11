package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {
    //自动找到模版
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(String name){
        System.out.println("OK!");
        jdbcTemplate.update("insert into user values(null, ?);", name);
        System.out.println("创建用户成功");
    }
    //查询数量
    public Integer findAllCount(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from user;",Integer.class);
        return count;
    }

//
}
