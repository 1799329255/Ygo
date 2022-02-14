package com.example.ygo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Article;
import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.entity.User;
import com.example.ygo.service.ArticleService;
import com.example.ygo.service.ArticlecategoryService;
import com.example.ygo.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Date;

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
    @Resource
    private ArticlecategoryService articlecategoryService;

    @Override
    public BaseService<Article, Long> getBaseService() {
        return articleService;
    }

    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据UserId获取文章列表")
    public ResponseData findByUserId(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        return ResponseMsgUtil.success(articleService.findByUserId(user.getId()));
    }

    @RequestMapping(value = "/findArticleInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取文章列表详情")
    public ResponseData findArticleInfo(Long userId,
                                        Long categoryId,
                                        String title,
                                        Long[] labelIds,
                                        String order,
                                        Integer pageNum,
                                        Integer pageSize){

        if (pageNum <= 0 || pageSize <= 0){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        Article article = new Article();
        article.setUserId(userId);
        article.setCategoryId(categoryId);
        article.setTitle(title);
        return ResponseMsgUtil.success(articleService.findArticleInfo(article,labelIds,order,pageNum,pageSize));
    }

    @RequestMapping(value = "/findArticleInfoPage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取文章列表详情(分页)")
    public ResponseData findArticleInfoPage(Long userId,
                                            Long categoryId,
                                            String title,
                                            Long[] labelIds,
                                            String order,
                                            Integer pageNum,
                                            Integer pageSize){
        if (pageNum==null || pageSize==null
                || pageNum <= 0 || pageSize <= 0){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        Article article = new Article();
        article.setUserId(userId);
        article.setCategoryId(categoryId);
        article.setTitle(title);
        return ResponseMsgUtil.success(articleService.findArticleInfoPage(article,labelIds,order,pageNum,pageSize));
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加文章")
    public ResponseData addArticle(@RequestBody Article article){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        if (article.getCategoryId()==null
                || StrUtil.isBlank(article.getTitle())
                || StrUtil.isBlank(article.getContent())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        Articlecategory articlecategory = articlecategoryService.findById(article.getCategoryId());
        if (articlecategory==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该文章分类不存在"));
            return ResponseMsgUtil.error("该文章分类不存在");
        }
        article.setId(null);
        article.setUserId(user.getId());
        article.setLikeNum((long) 0);
        article.setViewNum((long) 0);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.andLogicalDeleted(false);
        return ResponseMsgUtil.success(articleService.add(article));
    }

    @RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新文章")
    public ResponseData updateArticle(@RequestBody Article article){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        if (article.getId()==null
                || article.getCategoryId()==null
                || StrUtil.isBlank(article.getTitle())
                || StrUtil.isBlank(article.getContent())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        Article oldArticle = articleService.findById(article.getId());
        if (oldArticle==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该文章不存在"));
            return ResponseMsgUtil.error("该文章不存在");
        }
        Articlecategory articlecategory = articlecategoryService.findById(article.getCategoryId());
        if (articlecategory==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该文章分类不存在"));
            return ResponseMsgUtil.error("该文章分类不存在");
        }
        oldArticle.setUserId(user.getId());
        oldArticle.setCategoryId(article.getCategoryId());
        oldArticle.setTitle(article.getTitle());
        oldArticle.setContent(article.getContent());
        oldArticle.setPic(article.getPic());
        oldArticle.setLikeNum(article.getLikeNum());
        oldArticle.setViewNum(article.getViewNum());
        oldArticle.setUpdateTime(new Date());
        oldArticle.andLogicalDeleted(false);
        return ResponseMsgUtil.success(articleService.update(oldArticle));
    }

    @RequestMapping(value = "/deleteArticle", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除文章")
    public ResponseData deleteArticle(Long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        if (id==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(articleService.logicalDeleteById(id));
    }

}
