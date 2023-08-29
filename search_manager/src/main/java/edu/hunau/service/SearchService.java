package edu.hunau.service;


import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleWithBLOBs;
import org.springframework.data.domain.Page;

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
     * 被关键字文章列表
     * 通过关键词搜索文章以及标题
     *
     * @param keyword    关键字
     * @param pageNumber 页码
     * @param pageSize   页面大小
     * @return {@link Page}<{@link ForumArticleWithBLOBs}>
     */
    Page<ForumArticleWithBLOBs> getArticleListByKeyWord(String keyword, Integer pageNumber, Integer pageSize);

}
