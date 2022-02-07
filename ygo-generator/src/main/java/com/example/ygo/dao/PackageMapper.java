package com.example.ygo.dao;

import com.example.ygo.entity.Package;
import com.example.ygo.entity.PackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageMapper extends BaseMapper<Package,Long,PackageExample>{

}