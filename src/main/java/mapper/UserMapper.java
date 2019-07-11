package mapper;

import entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    //查询
    @Select("SELECT * FROM USER WHERE NAME=#{name}")
    User findByName(@Param("name") String name);

    //查询全部
    @Select("SELECT id, name FROM USER")
    List<User> findAll();

    //增加
    @Insert("INSERT INTO USER(NAME) VALUES(#{name})")
    int insert(@Param("name") String name);
}
