package edu.hunau.entity;

import java.io.Serializable;

public class ForumQuestion implements Serializable {
    private Integer questionId;

    private Integer userId;

    private String title;

    private Integer commentCount;

    private Integer answerCount;

    private Integer followerCount;

    private Integer voteCount;

    private Integer voteUpCount;

    private Integer voteDownCount;

    private Integer lastAnswerTime;

    private Integer createTime;

    private Integer updateTime;

    private Integer deleteTime;

    private static final long serialVersionUID = 1L;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
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

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
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

    public Integer getLastAnswerTime() {
        return lastAnswerTime;
    }

    public void setLastAnswerTime(Integer lastAnswerTime) {
        this.lastAnswerTime = lastAnswerTime;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Integer deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", userId=").append(userId);
        sb.append(", title=").append(title);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", answerCount=").append(answerCount);
        sb.append(", followerCount=").append(followerCount);
        sb.append(", voteCount=").append(voteCount);
        sb.append(", voteUpCount=").append(voteUpCount);
        sb.append(", voteDownCount=").append(voteDownCount);
        sb.append(", lastAnswerTime=").append(lastAnswerTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}