package edu.hunau.mapper;

import edu.hunau.entity.ForumTopicable;
import edu.hunau.entity.ForumTopicableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumTopicableMapper {
    long countByExample(ForumTopicableExample example);

    int deleteByExample(ForumTopicableExample example);

    int insert(ForumTopicable row);

    int insertSelective(ForumTopicable row);

    List<ForumTopicable> selectByExample(ForumTopicableExample example);

    int updateByExampleSelective(@Param("row") ForumTopicable row, @Param("example") ForumTopicableExample example);

    int updateByExample(@Param("row") ForumTopicable row, @Param("example") ForumTopicableExample example);
}