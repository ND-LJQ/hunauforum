package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumArticle implements Serializable {
    private Integer articleId;

    private Integer userId;

    private String title;

    private Integer commentCount;

    private Integer followerCount;

    private Integer voteCount;

    private Integer voteUpCount;

    private Integer voteDownCount;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Integer auditStatus;

    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
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

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", userId=").append(userId);
        sb.append(", title=").append(title);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", followerCount=").append(followerCount);
        sb.append(", voteCount=").append(voteCount);
        sb.append(", voteUpCount=").append(voteUpCount);
        sb.append(", voteDownCount=").append(voteDownCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}