package edu.hunau.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 论坛文章
 *
 * @author ND_LJQ
 * @date 2023/04/24
 */
public class ForumArticleWithBLOBs extends ForumArticle implements Serializable {
    @Field(type = FieldType.Text,name = "content_markdown",analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String contentMarkdown;


    @Field(type = FieldType.Text,name = "content_rendered",analyzer = "ik_max_word")
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