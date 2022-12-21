package edu.hunau.service;

import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.entity.ForumQuestion;
import edu.hunau.entity.ForumQuestionWithBLOBs;

import java.util.List;

/**
 * 问题服务
 *
 * @author ND_LJQ
 * @date 2022/12/20
 */
public interface QuestionService {


//    SELECT-START

    /**
     * 基本通过id查询问题
     *
     * @param questionId 问题id
     * @return {@link ForumQuestion}
     * @throws Exception 异常
     */
    public ForumQuestionWithBLOBs queryQuestionBasicById(String questionId) throws Exception;

    /**
     * 基本用户id查询问题
     *
     * @param userId 用户id
     * @return {@link List}<{@link ForumQuestion}>
     * @throws Exception 异常
     */
    public List<ForumQuestion> queryQuestionBasicByUserId(String userId) throws  Exception;


//    INSERT-START

    /**
     * 插入问题
     *
     * @param question 问题
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer insertQuestion(ForumQuestionWithBLOBs question) throws Exception;
}
