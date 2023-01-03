package edu.hunau.service;

import com.github.pagehelper.PageInfo;
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
    public ForumArticleWithBLOBs queryArticleBasicById(Integer articleId) throws Exception;

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


    /**
     * 选择所有主题文章页面
     * 选择所有话题下的文章
     *
     * @param topicId  主题id
     * @param pageNum  第n页
     * @param pageSize 页面大小
     * @return {@link PageInfo}<{@link ForumArticle}>
     * @throws Exception 异常
     */
    public PageInfo<ForumArticle> selectAllTopicArticlePage(String topicId,Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 分页请求文章
     *
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link PageInfo}<{@link ForumArticle}>
     */
    public PageInfo<ForumArticle> selectAllArticlePage(Integer pageNum,Integer pageSize);

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
