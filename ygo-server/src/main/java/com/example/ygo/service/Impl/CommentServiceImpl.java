package com.example.ygo.service.Impl;

import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.CommentMapper;
import com.example.ygo.entity.Comment;
import com.example.ygo.entity.CommentExample;
import com.example.ygo.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CommentServiceImpl
 * @description TODO
 * @since 2022/2/7 11:15
 */
@Service("comment")
public class CommentServiceImpl extends BaseServiceImpl<Comment,Long, CommentExample> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public BaseMapper<Comment, Long, CommentExample> getBaseMapper() {
        return commentMapper;
    }

    @Override
    public List<Comment> findByUserId(Long userId) {
        List<Comment> comments = commentMapper.findCommentInfoByExample(
                new CommentExample()
                        .createCriteria()
                        .andUserIdEqualTo(userId)
                        .andLogicalDeleted(false)
                        .example()
        );
        return comments;
    }

    @Override
    public List<Comment> findByArticleId(Long articleId) {
        List<Comment> comments = commentMapper.findCommentInfoByExample(
                new CommentExample()
                        .createCriteria()
                        .andArticleIdEqualTo(articleId)
                        .andLogicalDeleted(false)
                        .example()
        );
        return comments;
    }
}
