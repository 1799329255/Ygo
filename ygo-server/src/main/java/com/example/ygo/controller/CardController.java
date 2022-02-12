package com.example.ygo.controller;

import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Card;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.entity.User;
import com.example.ygo.service.BaseService;
import com.example.ygo.service.CardService;
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

    @Override
    public BaseService<Card, Long> getBaseService() {
        return cardService;
    }

    @RequestMapping(value = "/findCardInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据card获取卡牌列表详情")
    public ResponseData findCardInfo(@RequestBody Card card) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        if (card==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(cardService.findCardInfo(card));
    }

    @RequestMapping(value = "/findCard", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据card获取卡牌列表")
    public ResponseData findCard(@RequestBody Card card) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                    new ResponseData("401","账号未登录或已过期")));
            return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
        }
        if (card==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(cardService.findCard(card));
    }


}
