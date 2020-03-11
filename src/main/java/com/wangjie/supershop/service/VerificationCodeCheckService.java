package com.wangjie.supershop.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName VerificationCodeCheckService
 * @Description
 * @Author 25127
 * @Date 2020/3/10 16:43
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class VerificationCodeCheckService {

    private Map<String,String> telNumberToCorrectCode = new ConcurrentHashMap<>();

    public void addCode(String tel, String correctCode) {
        telNumberToCorrectCode.put(tel, correctCode);
    }

    public String getCorrectCode(String tel) {
        return telNumberToCorrectCode.get(tel);
    }
}
