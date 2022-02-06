package com.example.ygo.dao;

import com.example.ygo.entity.Permission;
import com.example.ygo.entity.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper extends BaseMapper<Permission,Long,PermissionExample>{

    List<Permission> findPermissionsWithRoles();
}