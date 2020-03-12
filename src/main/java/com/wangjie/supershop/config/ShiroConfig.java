package com.wangjie.supershop.config;

import com.wangjie.supershop.service.ShiroRealm;
import com.wangjie.supershop.service.VerificationCodeCheckService;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName ShiroConfig
 * @Description 用于配置拦截哪些URL
 * @Author 25127
 * @Date 2020/3/10 16:02
 * @Email jie.wang13@hand-china.com
 **/
@Configuration
//@ComponentScan(basePackages = {"org.apache.shiro.spring"})
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> pattern = new HashMap<>();
        // 第二个参数表示匿名用户也是可以访问这个接口的
        pattern.put("/api/code", "anon");
        pattern.put("/api/login", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(pattern);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(shiroRealm);
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
        securityManager.setSessionManager(new DefaultSessionManager());
        return securityManager;
    }

    @Bean(name = "myShiroRealm")
    public ShiroRealm shiroRealm(VerificationCodeCheckService verificationCodeCheckService){
        return new ShiroRealm(verificationCodeCheckService);
    }
}
