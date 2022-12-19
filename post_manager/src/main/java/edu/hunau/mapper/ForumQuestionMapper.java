package edu.hunau.mapper;

import edu.hunau.entity.ForumQuestion;
import edu.hunau.entity.ForumQuestionExample;
import edu.hunau.entity.ForumQuestionWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ForumQuestionMapper {
    long countByExample(ForumQuestionExample example);

    int deleteByExample(ForumQuestionExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(ForumQuestionWithBLOBs row);

    int insertSelective(ForumQuestionWithBLOBs row);

    List<ForumQuestionWithBLOBs> selectByExampleWithBLOBs(ForumQuestionExample example);

    List<ForumQuestion> selectByExample(ForumQuestionExample example);

    ForumQuestionWithBLOBs selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("row") ForumQuestionWithBLOBs row, @Param("example") ForumQuestionExample example);

    int updateByExampleWithBLOBs(@Param("row") ForumQuestionWithBLOBs row, @Param("example") ForumQuestionExample example);

    int updateByExample(@Param("row") ForumQuestion row, @Param("example") ForumQuestionExample example);

    int updateByPrimaryKeySelective(ForumQuestionWithBLOBs row);

    int updateByPrimaryKeyWithBLOBs(ForumQuestionWithBLOBs row);

    int updateByPrimaryKey(ForumQuestion row);
}