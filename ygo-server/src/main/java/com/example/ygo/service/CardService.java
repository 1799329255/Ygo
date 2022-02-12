package com.example.ygo.service;

import com.example.ygo.entity.Card;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CardService
 * @description TODO
 * @since 2022/2/7 18:49
 */
public interface CardService extends BaseService<Card,Long> {

    List<Card> findCardInfo(Card card);

    List<Card> findCard(Card card);

}
