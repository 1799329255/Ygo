package com.example.ygo.service.Impl;

import com.example.ygo.dao.ArticlecategoryMapper;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.ArticlecategoryExample;
import com.example.ygo.service.ArticlecategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleServiceImpl
 * @description TODO
 * @since 2022/2/6 16:44
 */
@Service("articlecategory")
public class ArticlecategoryServiceImpl extends BaseServiceImpl<Articlecategory,Long, ArticlecategoryExample> implements ArticlecategoryService {

    @Resource
    private ArticlecategoryMapper articlecategoryMapper;


    @Override
    public BaseMapper<Articlecategory, Long, ArticlecategoryExample> getBaseMapper() {
        return articlecategoryMapper;
    }
}
