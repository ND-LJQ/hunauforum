package edu.hunau.service;

import com.github.pagehelper.PageInfo;
import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumTopic;
import edu.hunau.entity.ForumTopicable;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * 主题服务
 *
 * @author ND_LJQ
 * @date 2022/12/21
 */
public interface TopicService {


    /**
     * 查询所有话题
     *
     * @return {@link List}<{@link ForumTopic}>
     * @throws Exception 异常
     */
    public List<ForumTopic> selectAllTopic() throws Exception;

    /**
     * 查通过ID询话题
     * @param topicId 主题id
     * @return {@link ForumTopic}
     * @throws Exception 异常
     */
    public ForumTopic selectTopicById(Long topicId) throws Exception;



    /**
     * 插入话题
     *
     * @param topic 主题
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer insertTopic(ForumTopic topic) throws Exception;

    /**
     * 插入话题与文章关系
     *
     * @param topicable topicable
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer insertTopicAble(ForumTopicable topicable) throws  Exception;


    /**
     * 通过id删除主题
     *
     * @param topicId 主题
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer deleteTopicById(String topicId) throws Exception;

    /**
     * 删除主题可以
     *
     * @param topicable topicable
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer deleteTopicAble(String topicable) throws Exception;


    /**
     * 更新主题
     *
     * @param topic 主题
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer updateTopic(ForumTopic topic) throws Exception;


    /**
     * 更新主题可以
     *
     * @param topicable topicable
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer updateTopicAble(ForumTopicable topicable) throws Exception;
}
