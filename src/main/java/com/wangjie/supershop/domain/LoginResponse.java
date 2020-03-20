package com.wangjie.supershop.domain;

/**
 * @ClassName LoginResponse
 * @Description
 * @Author 25127
 * @Date 2020/3/20 19:12
 * @Email jie.wang13@hand-china.com
 **/
public class LoginResponse {
    private boolean login = false;
    private User user;

    public LoginResponse() {
    }

    private LoginResponse(boolean login, User user) {
        this.login = login;
        this.user = user;
    }

    public static LoginResponse notLogin() {
        return new LoginResponse(false, null);
    }

    public static LoginResponse login(User user) {
        return new LoginResponse(true, user);
    }

    public User getUser() {
        return user;
    }

    public boolean isLogin() {
        return login;
    }
}

