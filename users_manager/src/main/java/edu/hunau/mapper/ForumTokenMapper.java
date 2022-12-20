package edu.hunau.mapper;

import edu.hunau.entity.ForumToken;
import edu.hunau.entity.ForumTokenExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumTokenMapper {
    long countByExample(ForumTokenExample example);

    int deleteByExample(ForumTokenExample example);

    int deleteByPrimaryKey(String token);

    int insert(ForumToken row);

    int insertSelective(ForumToken row);

    List<ForumToken> selectByExample(ForumTokenExample example);

    ForumToken selectByPrimaryKey(String token);

    int updateByExampleSelective(@Param("row") ForumToken row, @Param("example") ForumTokenExample example);

    int updateByExample(@Param("row") ForumToken row, @Param("example") ForumTokenExample example);

    int updateByPrimaryKeySelective(ForumToken row);

    int updateByPrimaryKey(ForumToken row);
}