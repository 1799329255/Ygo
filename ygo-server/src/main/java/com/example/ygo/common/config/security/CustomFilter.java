package com.example.ygo.common.config.security;

import cn.hutool.core.collection.CollectionUtil;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Permission;
import com.example.ygo.entity.Role;
import com.example.ygo.service.PermissionService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    @Resource
    private RedisTemplate redisTemplate;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Permission> permissions = null;
        //从redis获取所有权限及其角色列表，如果为空，去数据库获取
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            permissions = (List<Permission>)operations.get("permissions");
            if (CollectionUtil.isEmpty(permissions)){
                permissions = permissionService.findPermissionsWithRoles();
                // 将数据库取回的数据设置到Redis中
                operations.set("permissions",permissions);
            }
        } catch (Exception e){
            System.out.println("Redis连接失败");
        }

        if (CollectionUtil.isEmpty(permissions)){
            permissions = permissionService.findPermissionsWithRoles();
        }
        for (Permission permission : permissions) {
            // 判断请求url与权限列表是否匹配
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
