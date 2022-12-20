package edu.hunau.mapper;

import edu.hunau.entity.ForumUser;
import edu.hunau.entity.ForumUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumUserMapper {
    long countByExample(ForumUserExample example);

    int deleteByExample(ForumUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ForumUser row);

    int insertSelective(ForumUser row);

    List<ForumUser> selectByExample(ForumUserExample example);

    ForumUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("row") ForumUser row, @Param("example") ForumUserExample example);

    int updateByExample(@Param("row") ForumUser row, @Param("example") ForumUserExample example);

    int updateByPrimaryKeySelective(ForumUser row);

    int updateByPrimaryKey(ForumUser row);

    List<ForumUser> selectAll();

    ForumUser selectByEmail(String email);

    ForumUser selectByTel(String tel);
}