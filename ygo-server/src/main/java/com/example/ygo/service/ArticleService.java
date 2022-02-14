package com.example.ygo.service;

import com.example.ygo.entity.Article;
import com.example.ygo.entity.PageInfo;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleService
 * @description TODO
 * @since 2022/2/6 16:43
 */
public interface ArticleService extends BaseService<Article,Long>{

    List<Article> findByUserId(Long userId);

    List<Article> findArticleInfo(Article article,
                                  Long[] labelIds,
                                  String order,
                                  Integer pageNum,
                                  Integer pageSize);
    PageInfo<Article> findArticleInfoPage(Article article,
                                 Long[] labelIds,
                                 String order,
                                 Integer pageNum,
                                 Integer pageSize);
}
