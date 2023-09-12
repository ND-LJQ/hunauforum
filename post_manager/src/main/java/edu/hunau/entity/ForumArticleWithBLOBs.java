package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumArticleWithBLOBs extends ForumArticle implements Serializable {
    private String contentMarkdown;

    private String contentRendered;

    private static final long serialVersionUID = 1L;

    public String getContentMarkdown() {
        return contentMarkdown;
    }

    public void setContentMarkdown(String contentMarkdown) {
        this.contentMarkdown = contentMarkdown == null ? null : contentMarkdown.trim();
    }

    public String getContentRendered() {
        return contentRendered;
    }

    public void setContentRendered(String contentRendered) {
        this.contentRendered = contentRendered == null ? null : contentRendered.trim();
    }

    public ForumArticleWithBLOBs(){}

    public ForumArticleWithBLOBs(Long articleId, Long userId, String title, Date createTime,String contentMarkdown) {
        super(articleId,userId,title,createTime);
        this.contentMarkdown = contentMarkdown;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contentMarkdown=").append(contentMarkdown);
        sb.append(", contentRendered=").append(contentRendered);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}