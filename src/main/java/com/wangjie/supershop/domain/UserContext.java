package com.wangjie.supershop.domain;

/**
 * @ClassName UserContext
 * @Description
 * @Author 25127
 * @Date 2020/3/20 15:32
 * @Email jie.wang13@hand-china.com
 **/
public class UserContext {
    private static ThreadLocal<User> currentUser = new ThreadLocal<>();

    public static User getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(User user) {
        currentUser.set(user);
    }
}
