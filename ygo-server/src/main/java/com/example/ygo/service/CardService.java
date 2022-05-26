package com.example.ygo.service;

import com.example.ygo.entity.Card;
import com.example.ygo.entity.CardModel;
import com.example.ygo.entity.PageInfo;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CardService
 * @description TODO
 * @since 2022/2/7 18:49
 */
public interface CardService extends BaseService<Card,Long> {

    PageInfo<Card> findCardInfoPage(CardModel card);

    List<Card> findCardInfo(CardModel card);

}
