package com.example.ygo.service.Impl;

import com.example.ygo.dao.ArticleMapper;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.entity.Article;
import com.example.ygo.entity.ArticleExample;
import com.example.ygo.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleServiceImpl
 * @description TODO
 * @since 2022/2/6 16:44
 */
@Service("article")
public class ArticleServiceImpl extends BaseServiceImpl<Article,Long, ArticleExample> implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public BaseMapper<Article, Long, ArticleExample> getBaseMapper() {
        return articleMapper;
    }
}
