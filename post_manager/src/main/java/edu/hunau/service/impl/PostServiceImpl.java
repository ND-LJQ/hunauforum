package edu.hunau.service.impl;



import edu.hunau.entity.*;
import edu.hunau.mapper.ForumArticleMapper;
import edu.hunau.service.PostService;
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
public class PostServiceImpl implements PostService {
    @Autowired
    private ForumArticleMapper forumArticleMapper;

    @Override
    public List<ForumArticle> queryArticleBasicById(Integer articleId) throws Exception {
        ForumArticleExample article = new ForumArticleExample();
        ForumArticleExample.Criteria criteria = article.createCriteria();
        criteria.andUserIdEqualTo(articleId);
        List<ForumArticle> articles= forumArticleMapper.selectByExample(article);
        return articles;
    }

    @Override
    public List<ForumArticle> queryArticleBasicByUserId(Integer userId) throws Exception {
        ForumArticleExample articleInfo = new ForumArticleExample();
        ForumArticleExample.Criteria criteria = articleInfo.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<ForumArticle> articles = forumArticleMapper.selectByExample(articleInfo);
        return articles;
    }

    @Override
    public ForumArticleWithBLOBs queryQuestionBasicById(Integer questionId) throws Exception {
        return this.forumArticleMapper.selectByPrimaryKey(questionId);
    }

    @Override
    public List<ForumQuestion> queryQuestionBasicByUserId(Integer userId) throws Exception {
        ForumQuestionExample example = new ForumQuestionExample();
        ForumQuestionExample.Criteria criteria = example.createCriteria();
//        criteria.add
        return null;
    }

    @Override
    public ForumArticleWithBLOBs queryArticleContentById(Integer articleId) throws Exception {
        return this.forumArticleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public Integer insertArticle(ForumArticleWithBLOBs article) throws Exception {
        return this.forumArticleMapper.insertSelective(article);
    }

    @Override
    public Integer insertQuestion(ForumQuestionWithBLOBs question) throws Exception {
        return null;
    }

    @Override
    public Integer deleteArticle(ForumArticleWithBLOBs article) throws Exception {
        return this.forumArticleMapper.updateByPrimaryKeySelective(article);
    }
}
