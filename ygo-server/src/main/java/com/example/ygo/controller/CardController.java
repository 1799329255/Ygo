package com.example.ygo.controller;

import com.example.ygo.entity.Card;
import com.example.ygo.service.BaseService;
import com.example.ygo.service.CardService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
