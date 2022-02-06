package com.example.ygo.service;

import com.example.ygo.entity.Role;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className UserService
 * @description TODO
 * @since 2022/1/30 18:41
 */
public interface RoleService extends BaseService<Role,Long>{

    List<Role> findRolesByUserId(Long userId);

    List<Role> findRolesWithPermissions();

    Role findByName(String name);
}
