package edu.hunau.service.impl;

import edu.hunau.entity.ForumComment;
import edu.hunau.entity.ForumCommentExample;
import edu.hunau.mapper.ForumCommentMapper;
import edu.hunau.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论服务实现类
 *
 * @author ND_LJQ
 * @date 2022/12/20
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ForumCommentMapper forumCommentMapper;



    @Override
    public ForumComment selectCommentByCommentId(String commentId) throws Exception {
        return this.forumCommentMapper.selectByPrimaryKey(Long.valueOf(commentId));
    }

    @Override
    public List<ForumComment> selectCommentByCommentableId(String commentableId) throws Exception {
        ForumCommentExample forumCommentExample = new ForumCommentExample();
        ForumCommentExample.Criteria criteria = forumCommentExample.createCriteria();
        criteria.andCommentableIdEqualTo(Long.valueOf(commentableId));
        return this.forumCommentMapper.selectByExampleWithBLOBs(forumCommentExample);
    }


    @Override
    public Integer insertComment(ForumComment comment) throws Exception {
        return this.forumCommentMapper.insertSelective(comment);
    }


    @Override
    public Integer deleteCommentById(String commentId) throws Exception {
        return this.forumCommentMapper.deleteByPrimaryKey(Long.valueOf(commentId));
    }

    @Override
    public Integer updateCommentById(ForumComment forumComment) throws Exception {
        return this.forumCommentMapper.updateByPrimaryKeySelective(forumComment);
    }


}
