package com.wangjie.supershop.controller;

import com.wangjie.supershop.domain.LoginResponse;
import com.wangjie.supershop.domain.UserContext;
import com.wangjie.supershop.service.AuthService;
import com.wangjie.supershop.service.TelVerificationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AuthController
 * @Description
 * @Author 25127
 * @Date 2020/3/10 16:33
 * @Email jie.wang13@hand-china.com
 **/
@RestController
@RequestMapping("/api")
public class AuthController {
    private final TelVerificationService telVerificationService;
    private final AuthService authService;

    public AuthController(AuthService authService, TelVerificationService telVerificationService) {
        this.authService = authService;
        this.telVerificationService = telVerificationService;
    }

    @PostMapping("/code")
    // 请求验证码
    public void code(@RequestBody TelAndCode telAndCode, HttpServletResponse response) {
        if (telVerificationService.verifyTelParameter(telAndCode)) {
            authService.sendVerificationCode(telAndCode.getTel());
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }

    }

    @PostMapping("/login")
    public void login(@RequestBody TelAndCode telAndCode) {
        UsernamePasswordToken token = new UsernamePasswordToken(telAndCode.getTel(), telAndCode.code);
        token.setRememberMe(true);

        SecurityUtils.getSubject().login(token);
    }

    @GetMapping("/status")
    public Object loginStatus() {
        if (UserContext.getCurrentUser() == null) {
            return  LoginResponse.notLogin();
        } else {
            System.out.println(SecurityUtils.getSubject().getPrincipal());
            return LoginResponse.login(UserContext.getCurrentUser());
        }
    }

    @PostMapping("/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static class TelAndCode {
        private String tel;
        private String code;

        public TelAndCode(String tel, String code) {
            this.tel = tel;
            this.code = code;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}
