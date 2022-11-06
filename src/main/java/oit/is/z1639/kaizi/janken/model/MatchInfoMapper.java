package oit.is.z1639.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper {
  @Select("SELECT * from matchinfo where isActive = true;")
  ArrayList<MatchInfo> selectAllMatchInfo();

  @Insert("Insert into matchinfo (user1, user2, user1Hand, isActive) values (#{user1}, #{user2}, #{user1Hand}, #{isActive})")
  void InsertMatchInfo(int user1, int user2, String user1Hand, boolean isActive);
}
