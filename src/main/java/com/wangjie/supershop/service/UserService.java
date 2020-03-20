package com.wangjie.supershop.service;

import com.wangjie.supershop.dao.UserDao;
import com.wangjie.supershop.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUserIfNotExist(String tel) {
        User user = User.builder().tel(tel).name("test").avatarUrl("www.baidu.com").build();
        try {
            userDao.insertUser(user);
        } catch (Exception e) {
            return userDao.getUserByTel(tel);
        }
        return user;
    }

    public User getUserByTel(String tel) {
        return userDao.getUserByTel(tel);
    }
}
