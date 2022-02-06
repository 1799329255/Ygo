package com.example.ygo.service.Impl;

import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.RoleMapper;
import com.example.ygo.entity.Role;
import com.example.ygo.entity.RoleExample;
import com.example.ygo.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className RoleServiceImpl
 * @description TODO
 * @since 2022/1/30 19:00
 */
@Service("role")
public class RoleServiceImpl extends BaseServiceImpl<Role,Long, RoleExample> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public BaseMapper<Role, Long, RoleExample> getBaseMapper() {
        return roleMapper;
    }

    @Override
    public List<Role> findRolesByUserId(Long userId) {
        return roleMapper.findRolesByUserId(userId);
    }

    @Override
    public List<Role> findRolesWithPermissions() {
        return roleMapper.findRolesWithPermissions();
    }

    @Override
    public Role findByName(String name) {
        Role role = roleMapper.selectOneByExample(
                new RoleExample()
                        .createCriteria()
                        .andNameEqualTo(name)
                        .andStatusNotEqualTo(0)
                        .example()
        );
        return role;
    }
}
