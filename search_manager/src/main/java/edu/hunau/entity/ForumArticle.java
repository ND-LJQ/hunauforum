package edu.hunau.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ND_LJQ
 */
@Document(indexName = "forum_article")
public class ForumArticle implements Serializable {

    @Id
    private Long articleId;

    /**
     *  Keyword 是一种数据类型，用于表示不进行分词的字符串类型。
     *  与 Text 类型不同，Keyword 类型的字段通常被视为整体匹配，
     *  而不是像 Text 类型那样根据分词器将文本拆分成多个词条进行匹配。
     */

    @Field(type = FieldType.Keyword)
    private String userName;

    @Field(type = FieldType.Long,name = "user_id")
    private Long userId;


    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String title;

    @Field(type = FieldType.Integer,name = "comment_count")
    private Integer commentCount;

    @Field(type = FieldType.Integer,name = "follower_count")
    private Integer followerCount;

    @Field(type = FieldType.Integer,name = "vote_count")
    private Integer voteCount;

    @Field(type = FieldType.Integer,name = "vote_up_count")
    private Integer voteUpCount;

    @Field(type = FieldType.Integer,name = "vote_down_count")
    private Integer voteDownCount;

    @Field(type = FieldType.Date,name = "create_time")
    private Date createTime;

    @Field(type = FieldType.Date,name = "update_time")
    private Date updateTime;

    @Field(type = FieldType.Date,name = "delete_time")
    private Date deleteTime;

    @Field(type = FieldType.Integer,name = "audit_status")
    private Integer auditStatus;

    @Field(type = FieldType.Integer,name = "delete_status")
    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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