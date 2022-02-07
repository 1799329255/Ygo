package com.example.ygo.service;

import com.example.ygo.entity.Comment;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CommentService
 * @description TODO
 * @since 2022/2/7 11:14
 */
public interface CommentService extends BaseService<Comment,Long> {

    List<Comment> findByUserId(Long userId);

    List<Comment> findByArticleId(Long articleId);

}
