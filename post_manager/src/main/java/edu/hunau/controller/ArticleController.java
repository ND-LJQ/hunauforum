package edu.hunau.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.pagehelper.PageInfo;
import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.*;
import edu.hunau.service.ArticleService;
import edu.hunau.service.CommentService;
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
    private CommentService commentService;

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
    public BackMessage getArticleBasicInfoByArticleId(@PathVariable Integer articleId) throws Exception{
        try{
            ForumArticle article = this.articleService.queryArticleBasicById(articleId);
            return new BackMessage("查询成功!",SELECT_SUCCESSFUL,article);
        }catch (IndexOutOfBoundsException e){
            return new BackMessage("查询失败,文章不存在或已经被删除!",SELECT_FAILED);
        }
    }

    @PostMapping(value = {"/getarticlepage"})
    public BackMessage getArticlePage(HttpServletRequest request){
        BackMessage backMessage = new BackMessage();
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        if(pageSizeStr!=null&&!"".equals(pageSizeStr)){
            if(pageNumStr==null){
                pageNumStr = "1";
            }
            Integer pageSize = Integer.valueOf(pageSizeStr);
            Integer pageNum = Integer.valueOf(pageNumStr);
            PageInfo<ForumArticle> articles = this.articleService.selectAllArticlePage(pageNum,pageSize);
            return new BackMessage("查询成功",SELECT_SUCCESSFUL,articles);
        }else {
            return new BackMessage("查询失败,请检查参数是否正确",SELECT_FAILED);
        }
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
    public BackMessage getArticleContentsById(@PathVariable Integer articleId) throws Exception{
        BackMessage backMessage = new BackMessage();
        try{
            ForumArticleWithBLOBs forumArticleWithBLOBs = this.articleService.queryArticleContentById(articleId);
            List<ForumComment> forumCommentList = this.commentService.queryCommentListByArticleId(articleId);
            forumArticleWithBLOBs.setContentRendered("");
            ForumArticleFull forumArticleFull = new ForumArticleFull(forumArticleWithBLOBs,forumCommentList);
            return new BackMessage("查询成功",SELECT_SUCCESSFUL,forumArticleFull);
        }catch (Exception e){
            return new BackMessage("查询失败,请检查参数是否正确",SELECT_FAILED);
        }
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
    public BackMessage getUserArticles(@PathVariable String userId) throws Exception{
        try{
            List<ForumArticle> userArticles = this.articleService.queryArticleBasicByUserId(Integer.valueOf(userId));
            return new BackMessage("查询成功!",SELECT_SUCCESSFUL,userArticles);
        }catch (Exception e){
            return new BackMessage("查询失败!请检查参数是否正确",SELECT_SUCCESSFUL);
        }
    }

    /**
     * 文章发布
     * @param request 请求
     * @return {@link String}
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "请求", required = true)
    })
    @ApiOperation(value = "文章发布", notes = "文章发布", httpMethod = "POST")
    @PostMapping(value = {"/postings"})
    public BackMessage articlePublish(HttpServletRequest request) throws Exception {
        try {
            Long articleId = YitIdHelper.nextId();
            Date nowDate = dateUtil.getNowSqlDate();
            ForumArticleWithBLOBs article = new ForumArticleWithBLOBs(articleId,Long.valueOf(request.getParameter("userId")),request.getParameter("title"),nowDate,request.getParameter("content"));
            ForumTopicable topicable = new ForumTopicable(Long.valueOf(request.getParameter("topicId")),articleId,Integer.valueOf(request.getParameter("topicableType")),nowDate);
            ForumAudit forumAudit = new ForumAudit(YitIdHelper.nextId(),TYPE_ARTICLE,articleId,AUDIT_DEFAULT);
            this.articleService.insertArticle(article);
            this.topicService.insertTopicAble(topicable);
            this.articleService.insertArticleToAudit(forumAudit);
            return new BackMessage("发布成功!请等待管理员审核",INSERT_SUCCESSFUL);
        } catch (Exception e) {
            return new BackMessage("发布失败,请检查参数格式是否正确!",INSERT_FAILED);
        }
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
    public BackMessage deleteArticle(@PathVariable Integer articleId) throws Exception{
        ForumArticleWithBLOBs article = new ForumArticleWithBLOBs();
        article.setArticleId(Long.valueOf(articleId));
        article.setDeleteStatus(1);
        this.articleService.deleteArticle(article);
        return new BackMessage("删除成功!",DELETE_SUCCESSFUL);
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
    public BackMessage changeArticleBasic(HttpServletRequest request) throws Exception{
        try {
            String articleId = request.getParameter("articleId");
            String content = request.getParameter("content");
            String title = request.getParameter("title");
            ForumArticleWithBLOBs article = new ForumArticleWithBLOBs();
            article.setArticleId(Long.valueOf(articleId));
            if(title != null && !"".equals(title)){
                article.setTitle(title);
            }
            if(content != null && !"".equals(content)){
                article.setContentMarkdown(content);
            }
            article.setUpdateTime(dateUtil.getNowSqlDate());
            System.out.println(article);
            this.articleService.updateArticleBasicById(article);
            return new BackMessage("更新成功!",UPDATE_SUCCESSFUL);
        } catch (Exception e) {
            return new BackMessage("更新失败,请检查参数格式",UPDATE_FAILED);
        }
    }








}
