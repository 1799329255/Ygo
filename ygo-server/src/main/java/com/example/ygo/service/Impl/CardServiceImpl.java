package com.example.ygo.service.Impl;

import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.CardMapper;
import com.example.ygo.entity.Card;
import com.example.ygo.entity.CardExample;
import com.example.ygo.service.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CardServiceImpl
 * @description TODO
 * @since 2022/2/7 18:55
 */
@Service("card")
public class CardServiceImpl extends BaseServiceImpl<Card,Long, CardExample> implements CardService {

    @Resource
    private CardMapper cardMapper;

    @Override
    public BaseMapper<Card, Long, CardExample> getBaseMapper() {
        return cardMapper;
    }
}
