package edu.hunau.service.Impl;

import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.repository.EsArticleRepository;
import edu.hunau.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 搜索服务实现类
 *
 * @author ND_LJQ
 * @date 2023/04/22
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private EsArticleRepository esArticleRepository;

    @Override
    public List<ForumArticleWithBLOBs> getArticleListByTitle(String title, Integer pageNum, Integer pageSize) {
        return esArticleRepository.findByTitle(title,pageNum,pageSize);
    }

    @Override
    public Page<ForumArticleWithBLOBs> getArticleListByKeyWord(String keyword, Integer pageNumber, Integer pageSize) {
        return esArticleRepository.findByTitleOrContentMarkdownOrContentRendered(keyword,pageNumber,pageSize);
    }
}
