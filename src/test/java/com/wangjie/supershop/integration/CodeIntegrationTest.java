package com.wangjie.supershop.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import com.wangjie.supershop.SupershopApplication;
import com.wangjie.supershop.service.TelVerificationServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @ClassName CodeIntegerationTest
 * @Description
 * @Author 25127
 * @Date 2020/3/12 16:27
 * @Email jie.wang13@hand-china.com
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SupershopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.yml")
public class CodeIntegrationTest {
    @Autowired
    private Environment environment;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void returnHttpOkWhenParameterIsCorrect() throws JsonProcessingException {
        int responseCode = HttpRequest.post(getUrl("/api/code"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .send(objectMapper.writeValueAsString(TelVerificationServiceTest.VALID_PARAMETER))
                .code();
        Assertions.assertEquals(200, responseCode);
    }

    @Test
    public void returnHttpBadRequestWhenParameterIsNull() throws JsonProcessingException {
        int responseCode = HttpRequest.post(getUrl("/api/code"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .send(objectMapper.writeValueAsString(TelVerificationServiceTest.NULL_PARAMETER))
                .code();
        Assertions.assertEquals(404, responseCode);
    }

    private String getUrl(String apiName) {
        // 获取集成测试的端口号
        return "http://localhost:" + environment.getProperty("local.server.port") + apiName;
    }
}
