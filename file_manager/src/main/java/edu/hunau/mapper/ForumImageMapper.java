package edu.hunau.mapper;

import edu.hunau.entity.ForumImage;
import edu.hunau.entity.ForumImageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumImageMapper {
    long countByExample(ForumImageExample example);

    int deleteByExample(ForumImageExample example);

    int deleteByPrimaryKey(Long key);

    int insert(ForumImage row);

    int insertSelective(ForumImage row);

    List<ForumImage> selectByExample(ForumImageExample example);

    ForumImage selectByPrimaryKey(Long key);

    int updateByExampleSelective(@Param("row") ForumImage row, @Param("example") ForumImageExample example);

    int updateByExample(@Param("row") ForumImage row, @Param("example") ForumImageExample example);

    int updateByPrimaryKeySelective(ForumImage row);

    int updateByPrimaryKey(ForumImage row);
}