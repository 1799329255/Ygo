package com.example.ygo.service;

import com.example.ygo.entity.Articlelabel;
import com.example.ygo.entity.PageInfo;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleService
 * @description TODO
 * @since 2022/2/6 16:43
 */
public interface ArticlelabelService extends BaseService<Articlelabel,Long>{

    int addLabelsByArticleId(Long articleId, List<Long> labels);

    int updateLabelsByArticleId(Long articleId, List<Long> labels);

    PageInfo<Articlelabel> findArticleLabelInfoPage(Articlelabel articlelabel,
                                                  String order,
                                                  Integer pageNum,
                                                  Integer pageSize);
    boolean isUsed(Long id);
}
