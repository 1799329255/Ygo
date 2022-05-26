package com.example.ygo.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Article;
import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.Comment;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.service.ArticleService;
import com.example.ygo.service.ArticlecategoryService;
import com.example.ygo.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ArticleController
 * @description TODO
 * @since 2022/2/6 16:52
 */
@Controller
@RequestMapping(value = "/articlecategory")
@Api(value = "文章分类")
@Slf4j
public class ArticlecategoryController extends BaseController<Articlecategory,Long>{

    @Resource
    private ArticlecategoryService articlecategoryService;
    @Resource
    private ArticleService articleService;

    @Override
    public BaseService<Articlecategory, Long> getBaseService() {
        return articlecategoryService;
    }

    @RequestMapping(value = "/findCategoryInfoPage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取文章分类列表详情(分页)")
    public ResponseData findCommentInfoPage(String name,
                                            String order,
                                            Integer pageNum,
                                            Integer pageSize){
        if (pageNum==null || pageSize==null
                || pageNum <= 0 || pageSize <= 0){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        Articlecategory articlecategory = new Articlecategory();
        articlecategory.setName(name);
        return ResponseMsgUtil.success(articlecategoryService.findArticlecategoryInfoPage(articlecategory,order,pageNum,pageSize));
    }

    @Override
    public ResponseData logicalDeleteById(Long id) {
        if (id==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        Article article = new Article();
        article.setCategoryId(id);
        List<Article> articles = articleService.findArticleInfo(article, null, null, null, null);
        if (CollectionUtil.isNotEmpty(articles)){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该分类已被使用，不能删除！"));
            return ResponseMsgUtil.error("该分类已被使用，不能删除！");
        }
        return ResponseMsgUtil.success(articlecategoryService.logicalDeleteById(id));
    }

    @Override
    public ResponseData add(Articlecategory articlecategory) {
        if(articlecategory==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        if (StrUtil.isBlankIfStr(articlecategory.getName())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        articlecategory.andLogicalDeleted(false);
        return ResponseMsgUtil.success(articlecategoryService.add(articlecategory));
    }
}
