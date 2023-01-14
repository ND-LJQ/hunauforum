package edu.hunau.mapper;

import edu.hunau.entity.ForumVideo;
import edu.hunau.entity.ForumVideoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumVideoMapper {
    long countByExample(ForumVideoExample example);

    int deleteByExample(ForumVideoExample example);

    int deleteByPrimaryKey(Long videoid);

    int insert(ForumVideo row);

    int insertSelective(ForumVideo row);

    List<ForumVideo> selectByExample(ForumVideoExample example);

    List<ForumVideo> selectByUserId(Long userId);
    ForumVideo selectByPrimaryKey(Long videoid);

    int updateByExampleSelective(@Param("row") ForumVideo row, @Param("example") ForumVideoExample example);

    int updateByExample(@Param("row") ForumVideo row, @Param("example") ForumVideoExample example);

    int updateByPrimaryKeySelective(ForumVideo row);

    int updateByPrimaryKey(ForumVideo row);
}