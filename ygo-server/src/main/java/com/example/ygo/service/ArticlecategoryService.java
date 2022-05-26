package com.example.ygo.service;

import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.PageInfo;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleService
 * @description TODO
 * @since 2022/2/6 16:43
 */
public interface ArticlecategoryService extends BaseService<Articlecategory,Long>{

    PageInfo<Articlecategory> findArticlecategoryInfoPage(Articlecategory articlecategory,
                                          String order,
                                          Integer pageNum,
                                          Integer pageSize);
}
