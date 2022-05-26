package com.example.ygo.service.Impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.example.ygo.dao.ArticlelabelMapper;
import com.example.ygo.dao.ArticlewithlabelMapper;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.entity.*;
import com.example.ygo.service.ArticlelabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleServiceImpl
 * @description TODO
 * @since 2022/2/6 16:44
 */
@Service("articlelabel")
public class ArticlelabelServiceImpl extends BaseServiceImpl<Articlelabel,Long, ArticlelabelExample> implements ArticlelabelService {

    @Resource
    private ArticlelabelMapper articlelabelMapper;
    @Resource
    private ArticlewithlabelMapper articlewithlabelMapper;

    @Override
    public BaseMapper<Articlelabel, Long, ArticlelabelExample> getBaseMapper() {
        return articlelabelMapper;
    }

    @Override
    public int addLabelsByArticleId(Long articleId, List<Long> labels) {
        List<Articlewithlabel> articlewithlabels = labels.stream().map(label -> new Articlewithlabel(articleId, label)).collect(Collectors.toList());
        int i = articlewithlabelMapper.batchInsert(articlewithlabels);
        return i;
    }

    @Override
    public int updateLabelsByArticleId(Long articleId, List<Long> labels) {
        //先删除该文章与所有标签的联系
        articlewithlabelMapper.deleteByExample(
                new ArticlewithlabelExample()
                        .createCriteria()
                        .andArticleIdEqualTo(articleId)
                        .example()
        );
        int i = 0;
        if (CollectionUtil.isNotEmpty(labels)){
            //再添加标签的联系
            i = addLabelsByArticleId(articleId, labels);
        }
        return i;
    }

    @Override
    public PageInfo<Articlelabel> findArticleLabelInfoPage(Articlelabel articlelabel, String order, Integer pageNum, Integer pageSize) {
        ArticlelabelExample articlelabelExample = new ArticlelabelExample()
                .createCriteria()
                .when(StrUtil.isNotBlank(articlelabel.getName()), criteria -> criteria.andNameLike("%" + articlelabel.getName() + "%"))
                .andLogicalDeleted(false)
                .example()
                .orderBy(order)
                .when(pageNum != null && pageSize != null, example -> example.page(pageNum, pageSize));
        long total = articlelabelMapper.countByExample(articlelabelExample);
        List<Articlelabel> articleLabels = articlelabelMapper.findArticleLabelByInfoByExample(articlelabelExample);
        return new PageInfo<>(articleLabels,pageNum,pageSize,total);
    }

    @Override
    public List<Articlelabel> findAll() {
        ArticlelabelExample articlelabelExample = new ArticlelabelExample()
                .createCriteria()
                .andLogicalDeleted(false)
                .example();
        return getBaseMapper().selectByExample(articlelabelExample);
    }

    @Override
    public boolean isUsed(Long id) {
        ArticlewithlabelExample articlewithlabelExample = new ArticlewithlabelExample()
                .createCriteria()
                .when(id!=null,criteria -> criteria.andLabelIdEqualTo(id))
                .example();
        List<Articlewithlabel> articlewithlabels = articlewithlabelMapper.selectByExample(articlewithlabelExample);
        return CollectionUtil.isNotEmpty(articlewithlabels);
    }
}
