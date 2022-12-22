package edu.hunau.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumTopic;
import edu.hunau.entity.ForumTopicable;
import edu.hunau.entity.ForumTopicableExample;
import edu.hunau.mapper.ForumTopicMapper;
import edu.hunau.mapper.ForumTopicableMapper;
import edu.hunau.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主题服务实现类
 *
 * @author ND_LJQ
 * @date 2022/12/21
 */
@Service
public class TopicServiceImpl implements TopicService {


    @Autowired
    private ForumTopicMapper forumTopicMapper;

    @Autowired
    private ForumTopicableMapper forumTopicableMapper;

    @Override
    public List<ForumTopic> selectAllTopic() throws Exception {
        return  this.forumTopicMapper.selectAllTopic();
    }

    @Override
    public ForumTopic selectTopicById(Long topicId) throws Exception {
        return this.forumTopicMapper.selectByPrimaryKey(topicId);
    }

    @Override
    public Integer insertTopic(ForumTopic topic) throws Exception {
        return this.forumTopicMapper.insertSelective(topic);
    }

    @Override
    public Integer insertTopicAble(ForumTopicable topicable) throws Exception {
        return this.forumTopicableMapper.insertSelective(topicable);
    }

    @Override
    public Integer deleteTopicById(String topicId) throws Exception {
        return this.forumTopicMapper.deleteByPrimaryKey(Long.valueOf(topicId));
    }

    @Override
    public Integer deleteTopicAble(String topicableId) throws Exception {
        ForumTopicableExample forumTopicableExample =   new ForumTopicableExample();
        ForumTopicableExample.Criteria criteria = forumTopicableExample.createCriteria();
        criteria.andTopicableIdEqualTo(Long.valueOf(topicableId));
        return this.forumTopicableMapper.deleteByExample(forumTopicableExample);
    }

    @Override
    public Integer updateTopic(ForumTopic topic) throws Exception {
        return this.forumTopicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public Integer updateTopicAble(ForumTopicable topicable) throws Exception {
        Long topicableId = topicable.getTopicableId();;
        ForumTopicableExample forumTopicableExample = new ForumTopicableExample();
        ForumTopicableExample.Criteria criteria = forumTopicableExample.createCriteria();
        criteria.andTopicableIdEqualTo(topicableId);
        return this.forumTopicableMapper.updateByExampleSelective(topicable,forumTopicableExample);
    }


}
