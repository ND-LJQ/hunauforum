package edu.hunau.service;


import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleWithBLOBs;

import java.util.List;

/**
 * 搜索服务
 *
 * @author ND_LJQ
 * @date 2023/04/22
 */

public interface SearchService {

    /**
     * 通过标题查找文章
     *
     * @param title 文章名
     * @return {@link List}<{@link ForumArticle}>
     */
    List<ForumArticleWithBLOBs> getArticleListByTitle(String title, Integer pageNum, Integer pageSize);

    /**
     * 通过关键词搜索文章以及标题
     *
     * @param keyword 关键字
     * @return {@link List}<{@link ForumArticleWithBLOBs}>
     */
    List<ForumArticleWithBLOBs> getArticleListByKeyWord(String keyword);

}
