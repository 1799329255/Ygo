package com.example.ygo.service;

import com.example.ygo.entity.PageInfo;
import com.example.ygo.entity.User;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className UserService
 * @description TODO
 * @since 2022/1/30 18:41
 */
public interface UserService extends BaseService<User,Long>{

    User getUserInfo(Long id);

    User findByName(String name);

    User findByEmail(String email);

    User findByPhone(Long phone);

    PageInfo<User> findUserInfoPage(User user, String order, Integer pageNum, Integer pageSize);

    int addUser(User user);

    Boolean isRepeat(User user);

    List<User> findFansByUserId(Long id);

    PageInfo<User> findFansPageByUserId(Long id,Integer pageNum,Integer pageSize);

    List<User> findFollowsByUserId(Long id);

    PageInfo<User> findFollowsPageByUserId(Long id,Integer pageNum,Integer pageSize);

    int follow(Long fanId,Long followId);

    int unFollow(Long fanId,Long followId);

    boolean isFollow(Long fanId,Long followId);
}
