package edu.hunau.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.BackMessage;
import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.service.PostService;
import edu.hunau.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static edu.hunau.util.FinalData.*;

/**
 * 文章接口
 *
 * @author ND_LJQ
 * @date 2022/12/19
 */
@Api(value = "/forumpost", tags = {"文章接口"})
@RestController
@RequestMapping("/forumpost")
public class PostController {

    @Autowired
    private PostService postService;

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
            ForumArticle article = this.postService.queryArticleBasicById(articleId).get(0);
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
        ForumArticleWithBLOBs forumArticleWithBLOBs = this.postService.queryArticleContentById(articleId);
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
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "userId", value = "用户id", required = true)
    })
    @ApiOperation(value = "获取用户文章列表", notes = "获取用户文章列表", httpMethod = "GET")
    @GetMapping(value={"/article/user/{userId}"})
    public String getUserArticles(@PathVariable String userId) throws Exception{
        BackMessage backMessage = new BackMessage();
        List<ForumArticle> userArticles = this.postService.queryArticleBasicByUserId(Integer.valueOf(userId));
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
     * @throws Exception 异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "请求", required = true)
    })
    @ApiOperation(value = "文章发布", notes = "文章发布", httpMethod = "POST")
    @PostMapping(value = {"/postings"})
    public String articlePublish(HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        BackMessage backMessage = new BackMessage();
        String userId = params.getParameter("userId");
        String content = params.getParameter("content");
        String title = params.getParameter("title");
        ForumArticleWithBLOBs article = new ForumArticleWithBLOBs();
        article.setCreateTime(dateUtil.getNowSqlDate());
        article.setTitle(title);
        article.setContentMarkdown(content);
        article.setUserId(Long.valueOf(userId));
        article.setArticleId(YitIdHelper.nextId());
        if (this.postService.insertArticle(article)==1){
            //获得插入后的文章id
            System.out.println(article.getArticleId());
            backMessage.setCode(INSERT_SUCCESSFUL);
            backMessage.setMessage("发布成功!");
        }else {
            backMessage.setCode(INSERT_FAILED);
            backMessage.setMessage("发布失败,服务器繁忙,请稍后再试...");
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
        this.postService.deleteArticle(article);
        backMessage.setMessage("删除成功!");
        backMessage.setCode(DELETE_SUCCESSFUL);
        return JSON.toJSONString(backMessage);
    }


//    public String


}
