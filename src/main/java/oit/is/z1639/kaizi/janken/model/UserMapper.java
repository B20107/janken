package oit.is.z1639.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT id,name from users where id = #{id}")
  User selectById(int id);

  @Select("SELECT * from users where name = #{name}")
  User selectByName(String name);

  @Select("SELECT * from users;")
  ArrayList<User> selectAllUser();
}
