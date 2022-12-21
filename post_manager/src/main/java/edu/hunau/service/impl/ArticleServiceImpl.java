package edu.hunau.service.impl;



import edu.hunau.entity.*;
import edu.hunau.mapper.ForumArticleMapper;
import edu.hunau.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * post service impl
 *
 * @author ND_LJQ
 * @date 2022/12/19
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ForumArticleMapper forumArticleMapper;

    @Override
    public List<ForumArticle> queryArticleBasicById(Integer articleId) throws Exception {
        ForumArticleExample article = new ForumArticleExample();
        ForumArticleExample.Criteria criteria = article.createCriteria();
        criteria.andUserIdEqualTo(Long.valueOf(articleId));
        List<ForumArticle> articles= forumArticleMapper.selectByExample(article);
        return articles;
    }

    @Override
    public List<ForumArticle> queryArticleBasicByUserId(Integer userId) throws Exception {
        ForumArticleExample articleInfo = new ForumArticleExample();
        ForumArticleExample.Criteria criteria = articleInfo.createCriteria();
        criteria.andUserIdEqualTo(Long.valueOf(userId));
        List<ForumArticle> articles = forumArticleMapper.selectByExample(articleInfo);
        return articles;
    }



    @Override
    public ForumArticleWithBLOBs queryArticleContentById(Integer articleId) throws Exception {
        return this.forumArticleMapper.selectByPrimaryKey(Long.valueOf(articleId));
    }

    @Override
    public Integer insertArticle(ForumArticleWithBLOBs article) throws Exception {
        return this.forumArticleMapper.insertSelective(article);
    }


    @Override
    public Integer deleteArticle(ForumArticleWithBLOBs article) throws Exception {
        return this.forumArticleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public Integer updateArticleBasicById(ForumArticleWithBLOBs article) throws Exception {
        return this.forumArticleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public Integer updateArticleExtraById(ForumArticle article) throws Exception {
        return this.forumArticleMapper.updateByPrimaryKey(article);
    }
}