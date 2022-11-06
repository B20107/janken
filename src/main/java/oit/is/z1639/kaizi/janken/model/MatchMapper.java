package oit.is.z1639.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {
  @Select("SELECT * from matches;")
  ArrayList<Match> selectAllMatches();

  @Insert("Insert into matches (user1, user2, user1Hand, user2Hand) values (#{user1}, #{user2}, #{user1Hand}, #{user2Hand})")
  void InsertMatch(int user1, int user2, String user1Hand, String user2Hand);
}
