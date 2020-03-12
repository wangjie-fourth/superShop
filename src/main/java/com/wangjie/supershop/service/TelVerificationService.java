package com.wangjie.supershop.service;

import com.wangjie.supershop.controller.AuthController;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * @ClassName TelVerificationService
 * @Description
 * @Author 25127
 * @Date 2020/3/12 15:56
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class TelVerificationService {
    private static Pattern TEL_PATTERN = Pattern.compile("1\\d{10}");

    /**
     * 验证输入的参数是否合法
     *
     * @param telAndCode 输入的参数
     * @return true 合法，否则返回false
     */
    public boolean verifyTelParameter(AuthController.TelAndCode telAndCode) {
        if (telAndCode == null) {
            return false;
        } else if (telAndCode.getTel() == null) {
            return false;
        } else {
            return TEL_PATTERN.matcher(telAndCode.getTel()).find();
        }
    }
}
