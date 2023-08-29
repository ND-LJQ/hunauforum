package edu.hunau.entity;


import lombok.Data;

import java.util.List;

/**
 * 论坛文章完整
 *
 * @author ND_LJQ
 * @date 2023/08/28
 */
@Data
public class ForumArticleFull {
    private ForumArticleWithBLOBs forumArticleWithBLOBs;
    private List<ForumComment> commentList;

    public ForumArticleFull(ForumArticleWithBLOBs forumArticleWithBLOBs, List<ForumComment> commentList) {
        this.forumArticleWithBLOBs = forumArticleWithBLOBs;
        this.commentList = commentList;
    }


}
