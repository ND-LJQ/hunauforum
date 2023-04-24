package edu.hunau.repository.Impl;

import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.repository.EsArticleRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;



import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static edu.hunau.util.FinalData.SEARCH_PAGE_SIZE;

/**
 * @author ND_LJQ
 * @date 2023/04/23
 */
@Service
public class EsArticleRepositoryImpl implements EsArticleRepository {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Override
    public List<ForumArticleWithBLOBs> findByTitle(String keyword, Integer pageNumber, Integer pageSize) {
        // 页码
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        // 页数
        if (pageSize < 1) {
            pageSize = SEARCH_PAGE_SIZE;
        }
        Page<ForumArticleWithBLOBs> page = null;

        //添加需要查询的字段
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("title",keyword))
                .should(QueryBuilders.matchQuery("content_markdown",keyword));

        //构建高亮查询

        System.out.println(boolQueryBuilder);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                //排序
                .withSorts(SortBuilders.fieldSort("create_time").order(SortOrder.DESC)
                        ,SortBuilders.fieldSort("vote_up_count").order(SortOrder.DESC)
                ).withQuery(boolQueryBuilder)
                //分页
                .withPageable(PageRequest.of(pageNumber,pageSize))
                .withHighlightFields(
                        new HighlightBuilder.Field("title"),
                        new HighlightBuilder.Field("content_markdown")
                    )
                .withHighlightBuilder(new HighlightBuilder().preTags("<em>").postTags("</em>"))
                .build();


        System.out.println(searchQuery);

        //查询


        SearchHits<ForumArticleWithBLOBs> search = elasticsearchTemplate.search(searchQuery,ForumArticleWithBLOBs.class);

        System.out.println(search);
        //得到查询返回结果
        List<SearchHit<ForumArticleWithBLOBs>> searchHits = search.getSearchHits();

        List<ForumArticleWithBLOBs> articles = new ArrayList<>();


        //遍历返回的内容进行处理
        for (SearchHit<ForumArticleWithBLOBs> searchHit : searchHits){
            //高亮的内容
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();

            System.out.println(highlightFields);
            //将高亮的内容填充到content中
            //此时Fields已经被转换到了java对象格式,所以要使用在实体类中定义的名称contentMarkdown而不是es索引中的content_markdown属性注意区分
            searchHit.getContent().setTitle(highlightFields.get("title")==null ? searchHit.getContent().getTitle():highlightFields.get("title").get(0));
            searchHit.getContent().setContentMarkdown(highlightFields.get("contentMarkdown")==null ? searchHit.getContent().getContentMarkdown():highlightFields.get("contentMarkdown").get(0));
            //放到实体类中
            articles.add(searchHit.getContent());
        }

        return articles;
    }

    @Override
    public Page<ForumArticleWithBLOBs> findByTitleOrContentMarkdownOrContentRendered(String keyword, Integer pageNumber, Integer pageSize) {
        return null;
    }
}
