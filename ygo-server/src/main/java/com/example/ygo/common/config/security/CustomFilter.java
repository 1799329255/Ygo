package com.example.ygo.common.config.security;

import com.example.ygo.entity.Permission;
import com.example.ygo.entity.Role;
import com.example.ygo.service.PermissionService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求url分析所需的角色
 *
 * @author 旋木頵頵
 * @date 2021/10/22 12:03
 * @email 1020626977@qq.com
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Resource
    private PermissionService permissionService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Permission> permissions = permissionService.findPermissionsWithRoles();
        for (Permission permission : permissions) {
            // 判断请求url与菜单角色是否匹配
            if (antPathMatcher.match(permission.getUrl(), requestUrl)) {
                String[] strings = permission.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(strings);
            }
        }
        // 没匹配的url默认登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
