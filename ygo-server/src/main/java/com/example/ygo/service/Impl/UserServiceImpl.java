package com.example.ygo.service.Impl;

import cn.hutool.core.collection.CollectionUtil;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.UserMapper;
import com.example.ygo.dao.UserwithroleMapper;
import com.example.ygo.dao.UserwithuserMapper;
import com.example.ygo.entity.*;
import com.example.ygo.service.RoleService;
import com.example.ygo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 林屹峰
 * @version 1.0
 * @className UserServiceImpl
 * @description TODO
 * @since 2022/1/30 18:49
 */
@Service("user")
public class UserServiceImpl extends BaseServiceImpl<User,Long, UserExample> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserwithroleMapper userwithroleMapper;
    @Resource
    private RoleService roleService;
    @Resource
    private UserwithuserMapper userwithuserMapper;

    @Override
    public BaseMapper<User, Long, UserExample> getBaseMapper() {
        return userMapper;
    }

    @Override
    public User findByName(String name) {
        User user = userMapper.selectOneByExample(
                new UserExample()
                        .createCriteria()
                        .andNameEqualTo(name)
                        .andStatusNotEqualTo(0)
                        .example()
        );
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userMapper.selectOneByExample(
                new UserExample()
                        .createCriteria()
                        .andEmailEqualTo(email)
                        .andStatusNotEqualTo(0)
                        .example()
        );
        return user;
    }

    @Override
    public User findByPhone(Long phone) {
        User user = userMapper.selectOneByExample(
                new UserExample()
                        .createCriteria()
                        .andPhoneEqualTo(phone)
                        .andStatusNotEqualTo(0)
                        .example()
        );
        return user;
    }

    @Override
    public int addUser(User user) {
        int i = userMapper.insert(user);
        user = findByName(user.getName());
        if (i==1){
            Role role = roleService.findByName("ROLE_ordinary");
            if (role!=null){
                int j = userwithroleMapper.insert(new Userwithrole(user.getId(), role.getId()));
                if (j==1){
                    return j;
                }
            }
        }
        return 0;
    }

    @Override
    public Boolean isRepeat(User user) {
        List<User> users = userMapper.selectByExample(
                new UserExample()
                        .or()
                        .when(user.getName()!=null,criteria -> criteria.andNameEqualTo(user.getName()))
                        .example()
                        .or()
                        .when(user.getPhone()!=null,criteria -> criteria.andPhoneEqualTo(user.getPhone()))
                        .example()
                        .or()
                        .when(user.getEmail()!=null,criteria -> criteria.andEmailEqualTo(user.getEmail()))
                        .example()
        );
        if (CollectionUtil.isEmpty(users)){
            return false;
        }
        return true;
    }

    @Override
    public List<User> findFansByUserId(Long id) {
        List<Userwithuser> userwithusers = userwithuserMapper.selectByExample(
                new UserwithuserExample()
                        .createCriteria()
                        .andFanIdEqualTo(id)
                        .example()
        );
        List<Long> list = userwithusers.stream().map(Userwithuser::getFollowId).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(list)){
            return null;
        }
        List<User> users = userMapper.selectByExample(
                new UserExample()
                        .createCriteria()
                        .andIdIn(list)
                        .andStatusNotEqualTo(0)
                        .example()
        );
        return users;
    }

    @Override
    public List<User> findFollowsByUserId(Long id) {
        List<Userwithuser> userwithusers = userwithuserMapper.selectByExample(
                new UserwithuserExample()
                        .createCriteria()
                        .andFollowIdEqualTo(id)
                        .example()
        );
        List<Long> list = userwithusers.stream().map(Userwithuser::getFanId).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(list)){
            return null;
        }
        List<User> users = userMapper.selectByExample(
                new UserExample()
                        .createCriteria()
                        .andIdIn(list)
                        .andStatusNotEqualTo(0)
                        .example()
        );
        return users;
    }

}
