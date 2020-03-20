package com.wangjie.supershop.config;

import com.wangjie.supershop.domain.User;
import com.wangjie.supershop.domain.UserContext;
import com.wangjie.supershop.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserLoginInterceptor
 * @Description
 * @Author 25127
 * @Date 2020/3/20 15:36
 * @Email jie.wang13@hand-china.com
 **/

public class UserLoginInterceptor implements HandlerInterceptor {
    private final UserService userService;

    public UserLoginInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object tel = SecurityUtils.getSubject().getPrincipal();
        if (tel != null) {
            // 说明已经登录了
            User user = userService.getUserByTel(tel.toString());
            UserContext.setCurrentUser(user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 删除线程存得数据，因为这个线程会被复用的
        UserContext.setCurrentUser(null);
    }
}
