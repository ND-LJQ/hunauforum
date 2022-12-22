package edu.hunau.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.BackMessage;
import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.entity.ForumTopicable;
import edu.hunau.service.ArticleService;
import edu.hunau.service.TopicService;
import edu.hunau.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

import static edu.hunau.util.FinalData.*;

/**
 * 文章接口
 *
 * @author ND_LJQ
 * @date 2022/12/19
 */
@Api(value = "/forumpost", tags = {"public String"})
@RestController
@RequestMapping("/forumpost")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @Autowired
    private TopicService topicService;

    DateUtil dateUtil = new DateUtil();

    /**
     * 通过文章id来得到文章基础信息
     *
     * @param articleId 文章id
     * @return {@link String}
     * @throws Exception 异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "int", name = "articleId", value = "文章id", required = true)
    })
    @ApiOperation(value = "通过文章id来得到文章基础信息", notes = "通过文章id来得到文章基础信息", httpMethod = "GET")
    @GetMapping(value = {"/article/{articleId}"})
    public String getArticleBasicInfoByArticleId(@PathVariable Integer articleId) throws Exception{
        BackMessage backMessage = new BackMessage();
        try{
            ForumArticle article = this.articleService.queryArticleBasicById(articleId).get(0);
            backMessage.setMessage("查询成功!");
            backMessage.setCode(SELECT_SUCCESSFUL);
            backMessage.setData(article);
            return JSON.toJSONString(backMessage);
        }catch (IndexOutOfBoundsException e){
            backMessage.setCode(SELECT_FAILED);
            backMessage.setMessage("查询失败,文章不存在或已经被删除!");
        }
        return JSON.toJSONString(backMessage);
    }

    /**
     * 通过id获取文章内容
     *
     * @param articleId 文章id
     * @return {@link String}
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "int", name = "articleId", value = "文章id", required = true)
    })
    @ApiOperation(value = "通过id获取文章内容", notes = "通过id获取文章内容", httpMethod = "POST")
    @PostMapping(value = {"/article/{articleId}"})
    public String getArticleContentsById(@PathVariable Integer articleId) throws Exception{
        BackMessage backMessage = new BackMessage();
        ForumArticleWithBLOBs forumArticleWithBLOBs = this.articleService.queryArticleContentById(articleId);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getIncludes().add("contentRendered");
        String content = JSON.toJSONString(forumArticleWithBLOBs,filter);
        backMessage.setMessage("查询成功!");
        backMessage.setCode(SELECT_SUCCESSFUL);
        backMessage.setData(JSONObject.parseObject(content));
        return JSON.toJSONString(backMessage);
    }

    /**
     * 获取用户文章列表
     *
     * @param userId 用户id
     * @return {@link String}
     * @throws Exception 异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "string", name = "userId", value = "用户id", required = true)
    })
    @ApiOperation(value = "获取用户文章列表", notes = "获取用户文章列表", httpMethod = "GET")
    @GetMapping(value={"/article/user/{userId}"})
    public String getUserArticles(@PathVariable String userId) throws Exception{
        BackMessage backMessage = new BackMessage();
        List<ForumArticle> userArticles = this.articleService.queryArticleBasicByUserId(Integer.valueOf(userId));
        backMessage.setCode(SELECT_SUCCESSFUL);
        backMessage.setMessage("查询成功!");
        backMessage.setData(userArticles);
        return JSON.toJSONString(backMessage);
    }

    /**
     * 文章发布
     *
     * @param request 请求
     * @return {@link String}
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "请求", required = true)
    })
    @ApiOperation(value = "文章发布", notes = "文章发布", httpMethod = "POST")
    @PostMapping(value = {"/postings"})
    public String articlePublish(HttpServletRequest request) {
        BackMessage backMessage = new BackMessage();
        String userId = request.getParameter("userId");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        String topicId = request.getParameter("topicId");
        Long articleId = YitIdHelper.nextId();
        Date nowDate = dateUtil.getNowSqlDate();
        ForumArticleWithBLOBs article = new ForumArticleWithBLOBs();
        ForumTopicable topicable = new ForumTopicable();
        article.setCreateTime(nowDate);
        article.setTitle(title);
        article.setContentMarkdown(content);
        article.setUserId(Long.valueOf(userId));
        article.setArticleId(articleId);
        topicable.setTopicableId(articleId);
        topicable.setTopicId(Long.valueOf(topicId));
        topicable.setCreateTime(nowDate);
        try {
            this.articleService.insertArticle(article);
            this.topicService.insertTopicAble(topicable);
            backMessage.setCode(INSERT_SUCCESSFUL);
            backMessage.setMessage("发布成功!");
        } catch (Exception e) {
            backMessage.setCode(INSERT_FAILED);
            backMessage.setMessage("发布失败,请检查参数格式是否正确!");
            return JSON.toJSONString(backMessage);
        }
        return JSON.toJSONString(backMessage);
    }

    /**
     * 删除文章
     *
     * @param articleId 文章id
     * @return {@link String}
     * @throws Exception 异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "int", name = "articleId", value = "文章id", required = true)
    })
    @ApiOperation(value = "删除文章", notes = "删除文章", httpMethod = "GET")
    @GetMapping (value = {"/movearticle/{articleId}"})
    public String deleteArticle(@PathVariable Integer articleId) throws Exception{
        ForumArticleWithBLOBs article = new ForumArticleWithBLOBs();
        BackMessage backMessage = new BackMessage();
        article.setArticleId(Long.valueOf(articleId));
        article.setDeleteStatus(1);
        this.articleService.deleteArticle(article);
        backMessage.setMessage("删除成功!");
        backMessage.setCode(DELETE_SUCCESSFUL);
        return JSON.toJSONString(backMessage);
    }


//    public String


    /**
     * 修改文章内容
     *
     * @param request 请求
     * @return {@link String}
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "请求", required = true)
    })
    @ApiOperation(value = "修改文章内容", notes = "修改文章内容", httpMethod = "POST")
    @PostMapping(value = {"/changearticlemain"})
    public String changeArticleBasic(HttpServletRequest request){
        BackMessage backMessage = new BackMessage();
        String articleId = request.getParameter("articleId");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        ForumArticleWithBLOBs article = new ForumArticleWithBLOBs();
        article.setArticleId(Long.valueOf(articleId));

        if(title != null && title.equals("")){
            article.setTitle(title);
        }

        if(content != null && content.equals("")){
            article.setContentMarkdown(content);
        }


        article.setUpdateTime(dateUtil.getNowSqlDate());
        try {
            this.articleService.updateArticleBasicById(article);
            backMessage.setCode(UPDATE_SUCCESSFUL);
            backMessage.setMessage("更新成功!");
        } catch (Exception e) {
            backMessage.setCode(UPDATE_FAILED);
            backMessage.setMessage("更新失败,请检查参数格式");
            return JSON.toJSONString(backMessage);
        }
        return JSON.toJSONString(backMessage);
    }

}
