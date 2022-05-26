package com.example.ygo.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.example.ygo.dao.ArticlecategoryMapper;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.ArticlecategoryExample;
import com.example.ygo.entity.PageInfo;
import com.example.ygo.service.ArticlecategoryService;
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
@Service("articlecategory")
public class ArticlecategoryServiceImpl extends BaseServiceImpl<Articlecategory,Long, ArticlecategoryExample> implements ArticlecategoryService {

    @Resource
    private ArticlecategoryMapper articlecategoryMapper;


    @Override
    public BaseMapper<Articlecategory, Long, ArticlecategoryExample> getBaseMapper() {
        return articlecategoryMapper;
    }

    @Override
    public PageInfo<Articlecategory> findArticlecategoryInfoPage(Articlecategory articlecategory, String order, Integer pageNum, Integer pageSize) {
        ArticlecategoryExample articlecategoryExample = new ArticlecategoryExample()
                .createCriteria()
                .when(StrUtil.isNotBlank(articlecategory.getName()),criteria -> criteria.andNameLike("%" + articlecategory.getName() + "%"))
                .andLogicalDeleted(false)
                .example()
                .orderBy(order)
                .when(pageNum != null && pageSize != null, example -> example.page(pageNum, pageSize));
        long total = articlecategoryMapper.countByExample(articlecategoryExample);
        List<Articlecategory> articlecategories = articlecategoryMapper.findArticleCategoryInfoByExample(articlecategoryExample);
        return new PageInfo<>(articlecategories,pageNum,pageSize,total);
    }

    @Override
    public List<Articlecategory> findAll() {
        ArticlecategoryExample articlecategoryExample = new ArticlecategoryExample()
                .createCriteria()
                .andLogicalDeleted(false)
                .example();
        return getBaseMapper().selectByExample(articlecategoryExample);
    }
}
