package com.wangjie.supershop.config;

import com.wangjie.supershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SpringMvcConfig
 * @Description 用于拦截所有请求，并为每一个线程注入当前用户对象信息
 * @Author 25127
 * @Date 2020/3/20 15:25
 * @Email jie.wang13@hand-china.com
 **/
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    private final UserService userService;

    @Autowired
    public SpringMvcConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor(userService));
    }
}
