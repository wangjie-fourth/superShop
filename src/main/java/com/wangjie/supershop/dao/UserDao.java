package com.wangjie.supershop.dao;

import com.wangjie.supershop.domain.User;
import com.wangjie.supershop.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDao
 * @Description
 * @Author 25127
 * @Date 2020/3/10 16:47
 * @Email jie.wang13@hand-china.com
 **/
@Repository
public class UserDao {
    private final UserMapper userMapper;

    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;

    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public User getUserByTel(String tel) {
        return userMapper.getUserByTel(tel);
    }
}
