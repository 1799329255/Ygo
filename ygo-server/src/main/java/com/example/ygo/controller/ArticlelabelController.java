package com.example.ygo.controller;

import com.example.ygo.entity.Articlelabel;
import com.example.ygo.service.ArticlelabelService;
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
@RequestMapping(value = "/articlelabel")
@Api(value = "文章标签")
@Slf4j
public class ArticlelabelController extends BaseController<Articlelabel,Long>{

    @Resource
    private ArticlelabelService articlelabelService;

    @Override
    public BaseService<Articlelabel, Long> getBaseService() {
        return articlelabelService;
    }
}
