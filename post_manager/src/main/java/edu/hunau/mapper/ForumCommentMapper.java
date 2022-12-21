package edu.hunau.mapper;

import edu.hunau.entity.ForumComment;
import edu.hunau.entity.ForumCommentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumCommentMapper {
    long countByExample(ForumCommentExample example);

    int deleteByExample(ForumCommentExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(ForumComment row);

    int insertSelective(ForumComment row);

    List<ForumComment> selectByExampleWithBLOBs(ForumCommentExample example);

    List<ForumComment> selectByExample(ForumCommentExample example);

    ForumComment selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("row") ForumComment row, @Param("example") ForumCommentExample example);

    int updateByExampleWithBLOBs(@Param("row") ForumComment row, @Param("example") ForumCommentExample example);

    int updateByExample(@Param("row") ForumComment row, @Param("example") ForumCommentExample example);

    int updateByPrimaryKeySelective(ForumComment row);

    int updateByPrimaryKeyWithBLOBs(ForumComment row);

    int updateByPrimaryKey(ForumComment row);
}