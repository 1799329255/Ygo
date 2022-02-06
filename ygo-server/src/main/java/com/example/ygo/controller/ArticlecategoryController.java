package com.example.ygo.controller;

import com.example.ygo.entity.Articlecategory;
import com.example.ygo.service.ArticlecategoryService;
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
@RequestMapping(value = "/articlecategory")
@Api(value = "文章")
@Slf4j
public class ArticlecategoryController extends BaseController<Articlecategory,Long>{

    @Resource
    private ArticlecategoryService articlecategoryService;

    @Override
    public BaseService<Articlecategory, Long> getBaseService() {
        return articlecategoryService;
    }
}
