package com.example.ygo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.*;
import com.example.ygo.service.BaseService;
import com.example.ygo.service.CardService;
import com.example.ygo.service.MinioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CardController
 * @description TODO
 * @since 2022/2/7 18:57
 */
@Controller
@RequestMapping(value = "/card")
@Api(value = "卡牌")
@Slf4j
public class CardController extends BaseController<Card,Long> {

    @Resource
    private CardService cardService;
    @Resource
    private MinioService minioService;

    @Override
    public BaseService<Card, Long> getBaseService() {
        return cardService;
    }

    @RequestMapping(value = "/findCardInfoPage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据card获取卡牌列表详情(分页)")
    public ResponseData findCardInfoPage(CardModel cardModel) {

        if (cardModel==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        if (cardModel.getPageNum()==null || cardModel.getPageSize()==null
                || cardModel.getPageNum() <= 0 || cardModel.getPageSize() <= 0){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(cardService.findCardInfoPage(cardModel));
    }

    @RequestMapping(value = "/findCardInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据card获取卡牌列表详情")
    public ResponseData findCardInfo(CardModel cardModel) {

        if (cardModel==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        if (cardModel.getPageNum()!=null || cardModel.getPageSize()!=null){
            if (cardModel.getPageNum() <= 0 || cardModel.getPageSize() <= 0){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }

        }
        return ResponseMsgUtil.success(cardService.findCardInfo(cardModel));
    }

    @RequestMapping(value = "/updatePic", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新卡牌封面")
    public ResponseData updatePic(Long id, MultipartFile file) {
        try {
            if (file==null || id==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            Card card = cardService.findById(id);
            if (card==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该卡牌不存在，请重新输入"));
                return ResponseMsgUtil.error("该卡牌不存在，请重新输入");
            }
            //指定桶名
            String bucketName = "card-" + id.toString();
            //移除原来的文件
            minioService.removeObject(bucketName,card.getPic());
            //上传新的文件
            MultipartFileInfo multipartFileInfo = minioService.upload(bucketName, file);
            card.setPic(multipartFileInfo.getFileUrl());
            card.setUpdateTime(new Date());
            //更新数据库中用户信息
            cardService.update(card);
            return ResponseMsgUtil.success(multipartFileInfo);
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加卡牌")
    public ResponseData addCard(@RequestBody Card card){
        if (StrUtil.isBlank(card.getPassword()) || StrUtil.isBlank(card.getName())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        card.setLikeNum((long) 0);
        card.setViewNum((long) 0);
        card.setCreateTime(new Date());
        card.setUpdateTime(new Date());
        card.andLogicalDeleted(false);
        return ResponseMsgUtil.success(cardService.add(card));
    }



}
