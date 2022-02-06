package com.example.ygo.dao;

import com.example.ygo.entity.Userwithrole;
import com.example.ygo.entity.UserwithroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserwithroleMapper extends BaseMapper<Userwithrole,Long,UserwithroleExample>{

}