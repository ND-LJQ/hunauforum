package edu.hunau.controller;

import com.alibaba.fastjson.JSON;
import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.BackMessage;
import edu.hunau.entity.ForumComment;
import edu.hunau.service.CommentService;
import edu.hunau.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static edu.hunau.util.FinalData.*;

/**
 * 评论控制器
 *
 * @author ND_LJQ
 * @date 2022/12/21
 */
@Api(value = "/forumpost", tags = {"评论控制器"})
@RestController
@RequestMapping("/forumpost")
public class CommentController {
    @Autowired
    private CommentService commentService;

    DateUtil dateUtil = new DateUtil();

    /**
     * 获取文章/问题/回答的评论
     *
     * @param commentableId 请求
     * @return {@link String}
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "string", name = "commentableId", value = "请求", required = true)
    })
    @ApiOperation(value = "获取文章/问题/回答的评论", notes = "获取文章/问题/回答的评论", httpMethod = "GET")
    @GetMapping(value = {"/getcomments/{commentableId}"})
    public String getComment(@PathVariable String commentableId){
        BackMessage backMessage = new BackMessage();
        try {
            List<ForumComment> comments = this.commentService.selectCommentByCommentableId(commentableId);
            backMessage.setMessage("查询成功!");
            backMessage.setCode(SELECT_SUCCESSFUL);
            backMessage.setData(comments);
        } catch (Exception e) {
            backMessage.setMessage("查询失败!");
            backMessage.setCode(SELECT_FAILED);
            return JSON.toJSONString(backMessage);
        }
        return JSON.toJSONString(backMessage);
    }

    /**
     * 发布评论
     *
     * @param request 请求
     * @return {@link String}
     * @throws Exception 异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "请求", required = true)
    })
    @ApiOperation(value = "发布评论", notes = "发布评论", httpMethod = "POST")
    @PostMapping(value = {"/postcomment"})
    public String commentPost(HttpServletRequest request) throws Exception{
        BackMessage backMessage = new BackMessage();
        String userId = request.getParameter("userId");
        String commentableId = request.getParameter("commentableId");
        String content = request.getParameter("content");
        String commentType = request.getParameter("commentType");
        String parentId = request.getParameter("parentId");
        System.out.println(parentId);
        if(userId!=null&&commentableId!=null&&content!=null&&commentType!=null){
            ForumComment comment = new ForumComment();
            comment.setUserId(Long.valueOf(userId));
            comment.setCommentableId(Long.valueOf(commentableId));
            comment.setCommentId(YitIdHelper.nextId());
            comment.setCommentableType(Integer.valueOf(commentType));
            comment.setContent(content);
            comment.setCreateTime(dateUtil.getNowSqlDate());
            if (parentId != null && parentId != ""){
                comment.setParentId(Long.valueOf(parentId));
            }
            this.commentService.insertComment(comment);
            backMessage.setCode(INSERT_SUCCESSFUL);
            backMessage.setMessage("发布成功!");
            return JSON.toJSONString(backMessage);
        }
        backMessage.setCode(INSERT_FAILED);
        backMessage.setMessage("参数错误,请检查参数格式或者参数名称");
        return JSON.toJSONString(backMessage);
    }


    /**
     * 删除评论
     *
     * @param commentId 评论id
     * @return {@link String}
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "string", name = "commentId", value = "评论id", required = true)
    })
    @ApiOperation(value = "删除评论", notes = "删除评论", httpMethod = "DELETE")
    @DeleteMapping(value = {"/commentdelete/{commentId}"})
    public String commentDelete(@PathVariable String commentId) {
        BackMessage backMessage = new BackMessage();
        try {
            this.commentService.deleteCommentById(commentId);
            backMessage.setMessage("删除成功");
            backMessage.setCode(DELETE_SUCCESSFUL);
        } catch (Exception e) {
            backMessage.setMessage("删除失败,请检查参数格式或请求头格式");
            backMessage.setCode(DELETE_FAILED);
            return JSON.toJSONString(backMessage);
        }
        return JSON.toJSONString(backMessage);
    }


    /**
     * 修改评论
     *
     * @param request 请求
     * @return {@link String}
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "请求", required = true)
    })
    @ApiOperation(value = "修改评论", notes = "修改评论", httpMethod = "POST")
    @PostMapping(value = {"/changecomment"})
    public String changeComment (HttpServletRequest request){
        String commentId = request.getParameter("commentId");
        String content = request.getParameter("content");
        BackMessage backMessage = new BackMessage();
        ForumComment forumComment = new ForumComment();
        forumComment.setContent(content);
        forumComment.setCommentId(Long.valueOf(commentId));
        forumComment.setUpdateTime(dateUtil.getNowSqlDate());
        try {
            this.commentService.updateCommentById(forumComment);
            backMessage.setCode(UPDATE_SUCCESSFUL);
            backMessage.setMessage("更新成功!");
        } catch (Exception e) {
            backMessage.setCode(UPDATE_FAILED);
            backMessage.setMessage("更新失败!");
            return JSON.toJSONString(backMessage);
        }
        return JSON.toJSONString(backMessage);
    }
}
