package com.example.ygo.service.Impl;

import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.PermissionMapper;
import com.example.ygo.entity.Permission;
import com.example.ygo.entity.PermissionExample;
import com.example.ygo.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className UserServiceImpl
 * @description TODO
 * @since 2022/1/30 18:49
 */
@Service("permission")
public class PermissionServiceImpl extends BaseServiceImpl<Permission,Long, PermissionExample> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public BaseMapper<Permission, Long, PermissionExample> getBaseMapper() {
        return permissionMapper;
    }

    @Override
    public List<Permission> findPermissionsWithRoles() {
        return permissionMapper.findPermissionsWithRoles();
    }
}
