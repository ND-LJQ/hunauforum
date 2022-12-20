package edu.hunau.service;

import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.entity.ForumQuestion;
import edu.hunau.entity.ForumQuestionWithBLOBs;

import java.util.List;

/**
 * 文章服务
 *
 * @author ND_LJQ
 * @date 2022/12/19
 */
public interface PostService {


//    SELECT-START

    /**
     * 通过id查询文章
     *
     * @param articleId 文章id
     * @return int
     * @throws Exception 异常
     */
    public List<ForumArticle> queryArticleBasicById(Integer articleId) throws Exception;

    /**
     * 通过用户id查询文章
     *
     * @param userId 用户id
     * @return int
     * @throws Exception 异常
     */
    public List<ForumArticle> queryArticleBasicByUserId(Integer userId) throws Exception;

    /**
     * 基本通过id查询问题
     *
     * @param questionId 问题id
     * @return {@link ForumQuestion}
     * @throws Exception 异常
     */
    public ForumArticleWithBLOBs queryQuestionBasicById(Integer questionId) throws Exception;

    /**
     * 基本用户id查询问题
     *
     * @param userId 用户id
     * @return {@link List}<{@link ForumQuestion}>
     * @throws Exception 异常
     */
    public List<ForumQuestion> queryQuestionBasicByUserId(Integer userId) throws  Exception;

    /**
     * 通过id查询文章内容
     *
     * @param articleId 文章id
     * @return {@link ForumArticleWithBLOBs}
     * @throws Exception 异常
     */
    public ForumArticleWithBLOBs queryArticleContentById(Integer articleId) throws Exception;


//    INSERT-START

    /**
     * 插入文章
     *
     * @param article 文章
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer insertArticle(ForumArticleWithBLOBs article) throws Exception;


    /**
     * 插入问题
     *
     * @param question 问题
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer insertQuestion(ForumQuestionWithBLOBs question) throws Exception;



//    DELETE-START

    /**
     * 删除文章
     *
     * @param article 文章id
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer deleteArticle(ForumArticleWithBLOBs article) throws Exception;
}
