package com.example.ygo.dao;

import com.example.ygo.entity.Articlelabel;
import com.example.ygo.entity.ArticlelabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlelabelMapper extends BaseMapper<Articlelabel,Long,ArticlelabelExample>{

}