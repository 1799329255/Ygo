package com.example.ygo.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.Articlelabel;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.service.ArticlelabelService;
import com.example.ygo.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

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

    @RequestMapping(value = "/addArticlelabel", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加该文章与标签的联系")
    public ResponseData addArticlelabel(@RequestBody String reqBody){
        JSONObject jsonObject = JSONObject.parseObject(reqBody);
        Long articleId = jsonObject.getLong("articleId");
        //把labels json对象转换为list
        JSONArray jsonArray = jsonObject.getJSONArray("labels");
        String jsonArrayString = JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
        List<Long> labels = JSONObject.parseArray(jsonArrayString, Long.class);

        if (articleId==null || CollectionUtil.isEmpty(labels)){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(articlelabelService.addLabelsByArticleId(articleId,labels));
    }

    @RequestMapping(value = "/updateArticlelabel", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新该文章与标签的联系")
    public ResponseData updateArticlelabel(@RequestBody String reqBody){
        JSONObject jsonObject = JSONObject.parseObject(reqBody);
        Long articleId = jsonObject.getLong("articleId");
        //把labels json对象转换为list
        JSONArray jsonArray = jsonObject.getJSONArray("labels");
        String jsonArrayString = JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
        List<Long> labels = JSONObject.parseArray(jsonArrayString, Long.class);

        if (articleId==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(articlelabelService.updateLabelsByArticleId(articleId,labels));
    }

    @RequestMapping(value = "/findLabelInfoPage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取文章标签列表详情(分页)")
    public ResponseData findCommentInfoPage(String name,
                                            String order,
                                            Integer pageNum,
                                            Integer pageSize){
        if (pageNum==null || pageSize==null
                || pageNum <= 0 || pageSize <= 0){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        Articlelabel articlelabel = new Articlelabel();
        articlelabel.setName(name);
        return ResponseMsgUtil.success(articlelabelService.findArticleLabelInfoPage(articlelabel,order,pageNum,pageSize));
    }

    @Override
    public ResponseData logicalDeleteById(Long id) {
        if (id==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        if (articlelabelService.isUsed(id)){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该标签已被使用，不能删除！"));
            return ResponseMsgUtil.error("该标签已被使用，不能删除！");
        }
        return ResponseMsgUtil.success(articlelabelService.logicalDeleteById(id));
    }

    @Override
    public ResponseData add(Articlelabel articlelabel) {
        if(articlelabel==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        if (StrUtil.isBlankIfStr(articlelabel.getName())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        articlelabel.andLogicalDeleted(false);
        return ResponseMsgUtil.success(articlelabelService.add(articlelabel));
    }
}
