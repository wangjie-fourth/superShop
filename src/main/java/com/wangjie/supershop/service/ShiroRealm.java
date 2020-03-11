package com.wangjie.supershop.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * @ClassName ShiroRealm
 * @Description
 * @Author 25127
 * @Date 2020/3/10 17:18
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class ShiroRealm extends AuthorizingRealm {

    private final VerificationCodeCheckService verificationCodeCheckService;

    public ShiroRealm(VerificationCodeCheckService verificationCodeCheckService) {
        this.verificationCodeCheckService = verificationCodeCheckService;
        this.setCredentialsMatcher(new CredentialsMatcher() {
            @Override
            // 告诉 shiro 如何验证用户的身份信息
            public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
                return new String((char[]) token.getCredentials()).equals(info.getCredentials());
            }
        });
    }

    @Override
    // 验证是否有访问某个接口的权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    // 验证前端传来的身份是不是正确的
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String tel = (String) token.getPrincipal();
        String correctCode = verificationCodeCheckService.getCorrectCode(tel);

        return new SimpleAuthenticationInfo(tel, correctCode, getName());
    }
}
