package com.example.ygo.controller;

import com.example.ygo.entity.Article;
import com.example.ygo.service.ArticleService;
import com.example.ygo.service.BaseService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleController
 * @description TODO
 * @since 2022/2/6 16:52
 */
@Controller
@RequestMapping(value = "/article")
@Api(value = "文章")
@Slf4j
public class ArticleController extends BaseController<Article,Long>{

    @Resource
    private ArticleService articleService;

    @Override
    public BaseService<Article, Long> getBaseService() {
        return articleService;
    }
}
