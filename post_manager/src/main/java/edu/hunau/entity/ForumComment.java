package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumComment implements Serializable {
    private Long commentId;

    private Long commentableId;

    private Integer commentableType;

    private Long userId;

    private Integer replyCount;

    private Integer voteCount;

    private Integer voteUpCount;

    private Integer voteDownCount;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Long parentId;

    private String content;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentableId() {
        return commentableId;
    }

    public void setCommentableId(Long commentableId) {
        this.commentableId = commentableId;
    }

    public Integer getCommentableType() {
        return commentableType;
    }

    public void setCommentableType(Integer commentableType) {
        this.commentableType = commentableType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getVoteUpCount() {
        return voteUpCount;
    }

    public void setVoteUpCount(Integer voteUpCount) {
        this.voteUpCount = voteUpCount;
    }

    public Integer getVoteDownCount() {
        return voteDownCount;
    }

    public void setVoteDownCount(Integer voteDownCount) {
        this.voteDownCount = voteDownCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "ForumComment{" +
                "commentId=" + commentId +
                ", commentableId=" + commentableId +
                ", commentableType=" + commentableType +
                ", userId=" + userId +
                ", replyCount=" + replyCount +
                ", voteCount=" + voteCount +
                ", voteUpCount=" + voteUpCount +
                ", voteDownCount=" + voteDownCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}