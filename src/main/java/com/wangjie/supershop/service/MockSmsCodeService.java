package com.wangjie.supershop.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName MockSmsCodeService
 * @Description
 * @Author 25127
 * @Date 2020/3/10 16:29
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class MockSmsCodeService implements SmsCodeService {
    @Override
    public String sendSnsCode(String tel) {
        return "000000";
    }
}
