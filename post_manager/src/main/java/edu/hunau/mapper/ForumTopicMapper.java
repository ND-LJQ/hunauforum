package edu.hunau.mapper;

import edu.hunau.entity.ForumTopic;
import edu.hunau.entity.ForumTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumTopicMapper {
    long countByExample(ForumTopicExample example);

    int deleteByExample(ForumTopicExample example);

    int deleteByPrimaryKey(Long topicId);

    int insert(ForumTopic row);

    int insertSelective(ForumTopic row);

    List<ForumTopic> selectByExample(ForumTopicExample example);

    ForumTopic selectByPrimaryKey(Long topicId);

    int updateByExampleSelective(@Param("row") ForumTopic row, @Param("example") ForumTopicExample example);

    int updateByExample(@Param("row") ForumTopic row, @Param("example") ForumTopicExample example);

    int updateByPrimaryKeySelective(ForumTopic row);

    int updateByPrimaryKey(ForumTopic row);
}