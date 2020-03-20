package com.wangjie.supershop.service;

import com.wangjie.supershop.controller.AuthController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TelVerificationServiceTest {
    public static AuthController.TelAndCode VALID_PARAMETER = new AuthController.TelAndCode("138123456789", null);
    public static AuthController.TelAndCode NULL_PARAMETER = new AuthController.TelAndCode(null, null);
    public static AuthController.TelAndCode VALID_PARAMETER_CODE = new AuthController.TelAndCode("138123456789", "000000");


    @Test
    public void returnTrueIfValid() {
        Assertions.assertTrue(new TelVerificationService().verifyTelParameter(VALID_PARAMETER));
    }

    @Test
    public void returnFalseIfNull() {
        Assertions.assertFalse(new TelVerificationService().verifyTelParameter(NULL_PARAMETER));
        Assertions.assertFalse(new TelVerificationService().verifyTelParameter(null));
    }
}
