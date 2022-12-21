package edu.hunau.service;

import edu.hunau.entity.ForumComment;

import java.util.List;

/**
 * 评论服务
 *
 * @author ND_LJQ
 * @date 2022/12/20
 */
public interface CommentService {


//    SELECT-START


    /**
     * 选择发表评论评论id
     *
     * @param commentId 文章id
     * @return {@link List}<{@link ForumComment}>
     * @throws Exception 异常
     */
    public ForumComment  selectCommentByCommentId(String commentId) throws Exception;


    /**
     * 通过回答id查询评论
     *
     * @param commentableId 回答id
     * @return {@link List}<{@link ForumComment}>
     * @throws Exception 异常
     */
    public List<ForumComment>  selectCommentByCommentableId(String commentableId) throws Exception;

//    INSERT-START

    /**
     * 插入评论
     *
     * @param comment 评论
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer insertComment(ForumComment comment) throws Exception;


//    DELETE-START

    /**
     * 删除评论
     *
     * @param commentId 评论id
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer deleteCommentById(String commentId) throws Exception;


//    UPDATE-START


    /**
     * 通过id更新评论
     *
     * @param forumComment 论坛发表评论
     * @return {@link Integer}
     * @throws Exception 异常
     */
    public Integer updateCommentById(ForumComment forumComment) throws Exception;
}
