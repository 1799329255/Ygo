package com.example.ygo.dao;

import com.example.ygo.entity.Userwithuser;
import com.example.ygo.entity.UserwithuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserwithuserMapper extends BaseMapper<Userwithuser,Long,UserwithuserExample>{

}