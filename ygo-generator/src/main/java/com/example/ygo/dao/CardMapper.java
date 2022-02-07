package com.example.ygo.dao;

import com.example.ygo.entity.Card;
import com.example.ygo.entity.CardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardMapper extends BaseMapper<Card,Long,CardExample>{

}