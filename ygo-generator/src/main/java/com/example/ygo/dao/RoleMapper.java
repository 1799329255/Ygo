package com.example.ygo.dao;

import com.example.ygo.entity.Role;
import com.example.ygo.entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends BaseMapper<Role,Long,RoleExample>{

    List<Role> findRolesByUserId(Long userId);
    List<Role> findRolesWithPermissions();
}