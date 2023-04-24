package edu.hunau.repository;

import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleWithBLOBs;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * es文章库
 *
 * @author ND_LJQ
 * @date 2023/04/23
 * 使用单独的 Repository 接口或类来管理数据访问可以更加明确地表示其目的和职责
 */

//继承了 ElasticsearchRepository，那么需要将其泛型参数设置为实体类类型和主键类型。
public interface EsArticleRepository{
    /**
     * 通过标题查询文章
     *
     * @param keyword    关键字
     * @param pageNumber 页码
     * @param pageSize   页面大小
     * @return {@link Page}<{@link ForumArticle}>
     */
    List<ForumArticleWithBLOBs> findByTitle(String keyword, Integer pageNumber, Integer pageSize);

    /**
     * 发现通过标题或内容减价或内容呈现
     *
     * @param keyword    关键字
     * @param pageNumber 页码
     * @param pageSize   页面大小
     * @return {@link Page}<{@link ForumArticleWithBLOBs}>
     */
    Page<ForumArticleWithBLOBs> findByTitleOrContentMarkdownOrContentRendered(String keyword, Integer pageNumber, Integer pageSize);

}
