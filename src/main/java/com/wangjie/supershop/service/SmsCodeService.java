package com.wangjie.supershop.service;

/**
 * @ClassName SmsCodeService
 * @Description
 * @Author 25127
 * @Date 2020/3/10 16:27
 * @Email jie.wang13@hand-china.com
 **/
public interface SmsCodeService {

    /**
     * 向一个指定手机号发验证码，返回正确的答案
     * @param tel   目标手机号
     * @return      正确答案
     */
    String sendSnsCode(String tel);
}
