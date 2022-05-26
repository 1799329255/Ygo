package com.example.ygo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Article;
import com.example.ygo.entity.Comment;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.entity.User;
import com.example.ygo.service.ArticleService;
import com.example.ygo.service.BaseService;
import com.example.ygo.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CommentController
 * @description TODO
 * @since 2022/2/7 11:19
 */
@Controller
@RequestMapping(value = "/comment")
@Api(value = "评论")
@Slf4j
public class CommentController extends BaseController<Comment,Long> {

    @Resource
    private CommentService commentService;
    @Resource
    private ArticleService articleService;

    @Override
    public BaseService<Comment, Long> getBaseService() {
        return commentService;
    }

    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据UserId获取评论列表")
    public ResponseData findByUserId(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        return ResponseMsgUtil.success(commentService.findByUserId(user.getId()));
    }
    @RequestMapping(value = "/findByArticleId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ArticleId获取评论列表")
    public ResponseData findByArticleId(Long articleId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        return ResponseMsgUtil.success(commentService.findByArticleId(articleId));
    }

    @RequestMapping(value = "/findCommentInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取评论列表详情")
    public ResponseData findCommentInfo(Long articleId,
                                        Long userId,
                                        String content,
                                        String order,
                                        Integer pageNum,
                                        Integer pageSize){

        if(pageNum != null && pageSize != null){
            if (pageNum <= 0 || pageSize <= 0){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
        }

        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setUserId(userId);
        comment.setContent(content);
        return ResponseMsgUtil.success(commentService.findCommentInfo(comment,order,pageNum,pageSize));
    }

    @RequestMapping(value = "/findCommentInfoPage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取评论列表详情(分页)")
    public ResponseData findCommentInfoPage(Long articleId,
                                        Long userId,
                                        String content,
                                        String order,
                                        Integer pageNum,
                                        Integer pageSize){
        if (pageNum==null || pageSize==null
                || pageNum <= 0 || pageSize <= 0){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setUserId(userId);
        comment.setContent(content);
        return ResponseMsgUtil.success(commentService.findCommentInfoPage(comment,order,pageNum,pageSize));
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加评论")
    public ResponseData addComment(@RequestBody Comment comment){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        if (comment.getArticleId()==null || StrUtil.isBlank(comment.getContent())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        Article article = articleService.findById(comment.getArticleId());
        if (article==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该文章不存在"));
            return ResponseMsgUtil.error("该文章不存在");
        }
        comment.setId(null);
        comment.setLikeNum((long) 0);
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        comment.andLogicalDeleted(false);
        return ResponseMsgUtil.success(commentService.add(comment));
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新评论")
    public ResponseData updateComment(@RequestBody Comment comment){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        if (comment.getId()==null || comment.getArticleId()==null || StrUtil.isBlank(comment.getContent())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        Comment oldComment = commentService.findById(comment.getId());
        if (oldComment==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该评论不存在"));
            return ResponseMsgUtil.error("该评论不存在");
        }
        Article article = articleService.findById(comment.getArticleId());
        if (article==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该文章不存在"));
            return ResponseMsgUtil.error("该文章不存在");
        }
        oldComment.setUserId(user.getId());
        oldComment.setContent(article.getContent());
        oldComment.setPic(article.getPic());
        oldComment.setLikeNum(article.getLikeNum());
        oldComment.setUpdateTime(new Date());
        oldComment.andLogicalDeleted(false);
        return ResponseMsgUtil.success(commentService.update(oldComment));
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除评论")
    public ResponseData deleteComment(Long id){
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
        return ResponseMsgUtil.success(commentService.logicalDeleteById(id));
    }

}
