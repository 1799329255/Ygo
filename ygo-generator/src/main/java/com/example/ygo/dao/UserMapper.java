package com.example.ygo.dao;

import com.example.ygo.entity.User;
import com.example.ygo.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User,Long,UserExample>{

}