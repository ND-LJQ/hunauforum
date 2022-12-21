package edu.hunau.service.impl;

import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.entity.ForumQuestion;
import edu.hunau.entity.ForumQuestionExample;
import edu.hunau.entity.ForumQuestionWithBLOBs;
import edu.hunau.mapper.ForumQuestionMapper;
import edu.hunau.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 问题服务实现类
 *
 * @author ND_LJQ
 * @date 2022/12/20
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private ForumQuestionMapper forumQuestionMapper;

    @Override
    public ForumQuestionWithBLOBs queryQuestionBasicById(String questionId) throws Exception {
        return this.forumQuestionMapper.selectByPrimaryKey(Long.valueOf(questionId));
    }


    @Override
    public List<ForumQuestion> queryQuestionBasicByUserId(String userId) throws Exception {
        ForumQuestionExample example = new ForumQuestionExample();
        ForumQuestionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(Long.valueOf(userId));
        return this.forumQuestionMapper.selectByExample(example);
    }

    @Override
    public Integer insertQuestion(ForumQuestionWithBLOBs question) throws Exception {
        return null;
    }
}
