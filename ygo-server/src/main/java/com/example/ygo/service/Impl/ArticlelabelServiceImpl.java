package com.example.ygo.service.Impl;

import com.example.ygo.dao.ArticlelabelMapper;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.entity.Articlelabel;
import com.example.ygo.entity.ArticlelabelExample;
import com.example.ygo.service.ArticlelabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Override
    public BaseMapper<Articlelabel, Long, ArticlelabelExample> getBaseMapper() {
        return articlelabelMapper;
    }
}
