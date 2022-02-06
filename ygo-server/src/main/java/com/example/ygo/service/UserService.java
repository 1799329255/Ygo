package com.example.ygo.service;

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

    User findByName(String name);

    User findByEmail(String email);

    User findByPhone(Long phone);

    int addUser(User user);

    Boolean isRepeat(User user);

    List<User> findFansByUserId(Long id);

    List<User> findFollowsByUserId(Long id);
}
