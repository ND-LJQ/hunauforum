package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumTopicable implements Serializable {
    private Long topicId;

    private Long topicableId;

    private Integer topicableType;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getTopicableId() {
        return topicableId;
    }

    public void setTopicableId(Long topicableId) {
        this.topicableId = topicableId;
    }

    public Integer getTopicableType() {
        return topicableType;
    }

    public void setTopicableType(Integer topicableType) {
        this.topicableType = topicableType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", topicId=").append(topicId);
        sb.append(", topicableId=").append(topicableId);
        sb.append(", topicableType=").append(topicableType);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}