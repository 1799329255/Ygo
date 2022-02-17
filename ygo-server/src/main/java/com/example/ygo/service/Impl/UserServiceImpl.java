package com.example.ygo.service.Impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.UserMapper;
import com.example.ygo.dao.UserwithroleMapper;
import com.example.ygo.dao.UserwithuserMapper;
import com.example.ygo.entity.*;
import com.example.ygo.service.ArticleService;
import com.example.ygo.service.CommentService;
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
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;

    @Override
    public BaseMapper<User, Long, UserExample> getBaseMapper() {
        return userMapper;
    }

    @Override
    public User getUserInfo(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setArticles(articleService.findByUserId(id));
        user.setComments(commentService.findByUserId(id));
        user.setFollows(findFollowsByUserId(id));
        user.setFans(findFansByUserId(id));
        user.setRoles(roleService.findRolesByUserId(id));
        return user;
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
        //如果名字，手机，邮箱都没有，就不重复
        if (StrUtil.isBlank(user.getName()) && user.getPhone()==null && StrUtil.isBlank(user.getEmail())){
            return false;
        }

        List<User> users = userMapper.selectByExample(
                new UserExample()
                        .or()
                        .when(StrUtil.isBlank(user.getName()),criteria -> criteria.andNameEqualTo(user.getName()))
                        .example()
                        .or()
                        .when(user.getPhone()!=null,criteria -> criteria.andPhoneEqualTo(user.getPhone()))
                        .example()
                        .or()
                        .when(StrUtil.isBlank(user.getEmail()),criteria -> criteria.andEmailEqualTo(user.getEmail()))
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
    public PageInfo<User> findFansPageByUserId(Long id,Integer pageNum,Integer pageSize) {
        UserwithuserExample userwithuserExample = new UserwithuserExample()
                .createCriteria()
                .andFanIdEqualTo(id)
                .example()
                .when(pageNum != null && pageSize != null, example -> example.page(pageNum, pageSize));

        long count = userwithuserMapper.countByExample(userwithuserExample);
        List<Userwithuser> userwithusers = userwithuserMapper.selectByExample(userwithuserExample);
        List<Long> list = userwithusers.stream().map(Userwithuser::getFollowId).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(list)){
            return null;
        }
        List<User> users = userMapper.selectByExample(
                new UserExample()
                        .createCriteria()
                        .andIdIn(list)
                        .andLogicalDeleted(false)
                        .example()
        );
        return new PageInfo<>(users,pageNum,pageSize,count);
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

    @Override
    public PageInfo<User> findFollowsPageByUserId(Long id,Integer pageNum,Integer pageSize) {
        UserwithuserExample userwithuserExample = new UserwithuserExample()
                .createCriteria()
                .andFollowIdEqualTo(id)
                .example()
                .when(pageNum != null && pageSize != null, example -> example.page(pageNum, pageSize));

        long count = userwithuserMapper.countByExample(userwithuserExample);
        List<Userwithuser> userwithusers = userwithuserMapper.selectByExample(userwithuserExample);
        List<Long> list = userwithusers.stream().map(Userwithuser::getFanId).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(list)){
            return null;
        }
        List<User> users = userMapper.selectByExample(
                new UserExample()
                        .createCriteria()
                        .andIdIn(list)
                        .andLogicalDeleted(false)
                        .example()
        );
        return new PageInfo<>(users,pageNum,pageSize,count);
    }

}
