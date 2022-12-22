package edu.hunau.mapper;

import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleExample;
import edu.hunau.entity.ForumArticleWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumArticleMapper {
    long countByExample(ForumArticleExample example);

    int deleteByExample(ForumArticleExample example);

    int deleteByPrimaryKey(Long articleId);

    int insert(ForumArticleWithBLOBs row);

    int insertSelective(ForumArticleWithBLOBs row);

    List<ForumArticleWithBLOBs> selectByExampleWithBLOBs(ForumArticleExample example);

    List<ForumArticle> selectByExample(ForumArticleExample example);

    ForumArticleWithBLOBs selectByPrimaryKey(Long articleId);

    int updateByExampleSelective(@Param("row") ForumArticleWithBLOBs row, @Param("example") ForumArticleExample example);

    int updateByExampleWithBLOBs(@Param("row") ForumArticleWithBLOBs row, @Param("example") ForumArticleExample example);

    int updateByExample(@Param("row") ForumArticle row, @Param("example") ForumArticleExample example);

    int updateByPrimaryKeySelective(ForumArticleWithBLOBs row);

    int updateByPrimaryKeyWithBLOBs(ForumArticleWithBLOBs row);

    int updateByPrimaryKey(ForumArticle row);

    List<ForumArticle> selectTopicArticleByPrimaryKey(Long topicId);
}