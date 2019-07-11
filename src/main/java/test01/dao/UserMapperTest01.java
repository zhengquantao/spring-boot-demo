package test01.dao;

import entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapperTest01 {
    //查询
    @Select("SELECT * FROM USER WHERE NAME=#{name}")
    User findByName(@Param("name") String name);

    //增加
    @Insert("INSERT INTO USER(NAME) VALUES(#{name})")
    int insert(@Param("name") String name);
}
