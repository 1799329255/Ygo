package com.example.ygo.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.example.ygo.dao.ArticleMapper;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.entity.Article;
import com.example.ygo.entity.ArticleExample;
import com.example.ygo.entity.PageInfo;
import com.example.ygo.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Article> findByUserId(Long userId) {
        List<Article> articles = articleMapper.findArticleInfoByExample(
                new ArticleExample()
                        .createCriteria()
                        .andUserIdEqualTo(userId)
                        .andLogicalDeleted(false)
                        .example(),null
        );
        return articles;
    }

    @Override
    public List<Article> findArticleInfo(Article article,
                                         Long[] labelIds,
                                         String order,
                                         Integer pageNum,
                                         Integer pageSize) {

        List<Article> articles = articleMapper.findArticleInfoByExample(
                new ArticleExample()
                        .createCriteria()
                        .when(article.getUserId()!=null,criteria -> criteria.andUserIdEqualTo(article.getUserId()))
                        .when(article.getCategoryId()!=null,criteria -> criteria.andCategoryIdEqualTo(article.getCategoryId()))
                        .when(StrUtil.isNotBlank(article.getTitle()), criteria -> criteria.andTitleLike("%"+article.getTitle()+"%"))
                        .andLogicalDeleted(false)
                        .example()
                        .orderBy(order)
                        .when(pageNum!=null && pageSize!=null,example -> example.page(pageNum,pageSize))
                        ,labelIds
        );
        return articles;
    }

    @Override
    public PageInfo<Article> findArticleInfoPage(Article article, Long[] labelIds, String order, Integer pageNum, Integer pageSize) {
        ArticleExample articleExample = new ArticleExample()
                .createCriteria()
                .when(article.getUserId() != null, criteria -> criteria.andUserIdEqualTo(article.getUserId()))
                .when(article.getCategoryId() != null, criteria -> criteria.andCategoryIdEqualTo(article.getCategoryId()))
                .when(StrUtil.isNotBlank(article.getTitle()), criteria -> criteria.andTitleLike("%" + article.getTitle() + "%"))
                .andLogicalDeleted(false)
                .example()
                .orderBy(order)
                .when(pageNum != null && pageSize != null, example -> example.page(pageNum, pageSize));
        long total = articleMapper.countInfoByExample(articleExample,labelIds);
        List<Article> articles = articleMapper.findArticleInfoByExample(articleExample, labelIds);
        return new PageInfo<>(articles,pageNum,pageSize,total);
    }
}
