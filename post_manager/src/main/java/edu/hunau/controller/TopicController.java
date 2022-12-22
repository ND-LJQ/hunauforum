package edu.hunau.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.BackMessage;
import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumTopic;
import edu.hunau.service.ArticleService;
import edu.hunau.service.TopicService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

import static edu.hunau.util.FinalData.*;

/**
 * 主题控业务层
 *
 * @author ND_LJQ
 * @date 2022/12/22
 */
@RestController
@RequestMapping(value = {"/forumtopic"})
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = {"/createtopic"})
    public String createTopic(HttpServletRequest request) throws Exception {
        BackMessage backMessage = new BackMessage();
        ForumTopic topic = new ForumTopic();
        String name = request.getParameter("topicName");
        String description = request.getParameter("description");
        Long topicId = YitIdHelper.nextId();
        if (name!=null&&description!=null){
            topic.setTopicId(topicId);
            topic.setName(name);
            topic.setDescription(description);
            this.topicService.insertTopic(topic);
            backMessage.setCode(INSERT_SUCCESSFUL);
            backMessage.setMessage("创建成功!");
            backMessage.setData(topicId);
            return JSON.toJSONString(backMessage);
        }
        backMessage.setCode(INSERT_FAILED);
        backMessage.setMessage("创建失败,请检测参数是否正确");
        return JSON.toJSONString(backMessage);
    }

    /**
     * 移除话题
     *
     * @param topicId 请求
     * @return {@link String}
     * @throws Exception 异常
     */
    @DeleteMapping(value = {"/movetopic/{topicId}"})
    public String moveTopic(@PathVariable String topicId){
        BackMessage backMessage = new BackMessage();
        try {
            this.topicService.deleteTopicById(topicId);
            backMessage.setCode(DELETE_SUCCESSFUL);
            backMessage.setMessage("删除成功!");
        } catch (Exception e) {
            backMessage.setCode(DELETE_FAILED);
            backMessage.setMessage("删除失败!");
            return JSON.toJSONString(backMessage);
        }
        return JSON.toJSONString(backMessage);
    }


    /**
     * 改变主题信息
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */
    @PostMapping(value = {"/changetopic"})
    public String changeTopicInfo(HttpServletRequest request) throws Exception{
        BackMessage backMessage = new BackMessage();
        ForumTopic topic = new ForumTopic();
        Map map = request.getParameterMap();
        map.forEach((k,v)->{
            if(v.equals("")){
                map.put(k,null);
            }
        });
        //将map中的值赋值给
        BeanUtils.populate(topic,map);

        this.topicService.updateTopic(topic);
        backMessage.setMessage("修改成功!");
        backMessage.setCode(UPDATE_SUCCESSFUL);
        return JSON.toJSONString(backMessage);
    }

    /**
     * 分页查询主题下的文章
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */
    @PostMapping(value = {"/gettopicarticle"})
    public String getTopicAllArticle(HttpServletRequest request) throws Exception{
        BackMessage backMessage = new BackMessage();
        String topicId = request.getParameter("topicId");
        Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
        if(topicId!=null&&pageSize!=null){
          PageInfo<ForumArticle> articles =  this.articleService.selectAllTopicArticlePage(topicId,pageNum,pageSize);
          backMessage.setCode(SELECT_SUCCESSFUL);
          backMessage.setMessage("查询成功!");
          backMessage.setData(articles);
          return JSON.toJSONString(backMessage);
        }
        backMessage.setCode(SELECT_FAILED);
        backMessage.setMessage("查询失败,请检查参数格式");
        return JSON.toJSONString(backMessage);
    }


    @GetMapping(value = {"/gettopic"})
    public String getAllTopic(HttpServletRequest request) throws Exception{
        BackMessage backMessage = new BackMessage();
        List<ForumTopic> topicList = this.topicService.selectAllTopic();
        backMessage.setCode(SELECT_SUCCESSFUL);
        backMessage.setMessage("查询成功!");
        backMessage.setData(topicList);
        return JSON.toJSONString(backMessage);
    }

    @GetMapping(value = {"/gettopic/{topicId}"})
    public String getTopicInfo(@PathVariable String topicId) throws Exception {
        BackMessage backMessage = new BackMessage();
        ForumTopic topicInfo = this.topicService.selectTopicById(Long.valueOf(topicId));
        backMessage.setCode(SELECT_SUCCESSFUL);
        backMessage.setMessage("查询成功!");
        backMessage.setData(topicInfo);
        return JSON.toJSONString(backMessage);
    }
}
