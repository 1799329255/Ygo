package com.example.ygo.dao;

import com.example.ygo.entity.Cardwithpackage;
import com.example.ygo.entity.CardwithpackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardwithpackageMapper extends BaseMapper<Cardwithpackage,Long,CardwithpackageExample>{
}