package com.example.ygo.service.Impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.CardMapper;
import com.example.ygo.entity.Card;
import com.example.ygo.entity.CardExample;
import com.example.ygo.service.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public CardExample createCardExample(Card card){

        final List<String> locales;
        final List<String> type_cs;
        final List<String> link_arrows;
        final List<String> rares;

        if (StrUtil.isNotBlank(card.getLocale())){
            locales = Arrays.stream(card.getLocale().split(",")).collect(Collectors.toList());
        } else {
            locales = null;
        }
        if (StrUtil.isNotBlank(card.getTypeC())){
            type_cs = Arrays.stream(card.getTypeC().split(",")).collect(Collectors.toList());
        } else {
            type_cs = null;
        }
        if (StrUtil.isNotBlank(card.getLinkArrow())){
            link_arrows = Arrays.stream(card.getLinkArrow().split(",")).collect(Collectors.toList());
        } else {
            link_arrows = null;
        }
        if (StrUtil.isNotBlank(card.getRare())){
            rares = Arrays.stream(card.getRare().split(",")).collect(Collectors.toList());
        } else {
            rares = null;
        }

        return new CardExample()
                .distinct(true)
                .createCriteria()
                .when(StrUtil.isNotBlank(card.getPassword()), criteria -> criteria.andPasswordEqualTo(card.getPassword()))
                .when(StrUtil.isNotBlank(card.getName()), criteria -> criteria.andNameLike("%" + card.getName() + "%"))
                .when(StrUtil.isNotBlank(card.getBan()), criteria -> criteria.andBanEqualTo(card.getBan()))
                .when(CollectionUtil.isNotEmpty(locales), criteria -> locales.forEach(criteria::andLocaleEqualTo))
                .when(StrUtil.isNotBlank(card.getTypeF()), criteria -> criteria.andTypeFEqualTo(card.getTypeF()))
                .when(CollectionUtil.isNotEmpty(type_cs), criteria -> type_cs.forEach(criteria::andTypeCEqualTo))
                .when(StrUtil.isNotBlank(card.getPic()), criteria -> criteria.andPicEqualTo(card.getPic()))
                .when(card.getLevel() != null, criteria -> criteria.andLevelEqualTo(card.getLevel()))
                .when(StrUtil.isNotBlank(card.getAttribute()), criteria -> criteria.andAttributeEqualTo(card.getAttribute()))
                .when(StrUtil.isNotBlank(card.getRace()), criteria -> criteria.andRaceEqualTo(card.getRace()))
                .when(StrUtil.isNotBlank(card.getAtk()), criteria -> criteria.andAtkEqualTo(card.getAtk()))
                .when(StrUtil.isNotBlank(card.getDef()), criteria -> criteria.andDefEqualTo(card.getDef()))
                .when(card.getPend() != null, criteria -> criteria.andPendEqualTo(card.getPend()))
                .when(card.getLink() != null, criteria -> criteria.andLinkEqualTo(card.getLink()))
                .when(CollectionUtil.isNotEmpty(link_arrows), criteria -> link_arrows.forEach(criteria::andLinkArrowEqualTo))
                .when(StrUtil.isNotBlank(card.getPendDesc()), criteria -> criteria.andPendDescEqualTo(card.getPendDesc()))
                .when(StrUtil.isNotBlank(card.getDesc()), criteria -> criteria.andDescEqualTo(card.getDesc()))
                .when(CollectionUtil.isNotEmpty(rares), criteria -> rares.forEach(criteria::andRareEqualTo))
                .when(StrUtil.isNotBlank(card.getHref()), criteria -> criteria.andHrefEqualTo(card.getHref()))
                .when(card.getLikeNum() != null, criteria -> criteria.andLikeNumEqualTo(card.getLikeNum()))
                .when(card.getViewNum() != null, criteria -> criteria.andViewNumEqualTo(card.getViewNum()))
                .andLogicalDeleted(false)
                .example()
                .orderBy("id");
    }

    @Override
    public List<Card> findCardInfo(Card card) {
        List<Card> cards = cardMapper.findCardInfoByExample(createCardExample(card));
        return cards;
    }

    @Override
    public List<Card> findCard(Card card) {
        List<Card> cards = cardMapper.findCardInfoByExample(createCardExample(card));
        return null;
    }
}
