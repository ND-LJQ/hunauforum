package edu.hunau.service;

import edu.hunau.entity.*;

import java.util.List;

/**
 * 文章服务
 *
 * @author ND_LJQ
 * @date 2022/12/19
 */
public interface ArticleService {


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



//    DELETE-START

    /**
     * 删除文章
     *
     * @param article 文章id
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer deleteArticle(ForumArticleWithBLOBs article) throws Exception;



//    UPDATE-START


    /**
     * 更新文章内容
     *
     * @param article 文章
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer updateArticleBasicById(ForumArticleWithBLOBs article) throws Exception;

    /**
     * 更新文章其他属性
     *
     * @param article 文章
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer updateArticleExtraById(ForumArticle article) throws Exception;
}
