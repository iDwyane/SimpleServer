package com.example.test;

import com.example.test.entity.member.LoginRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApplicationTests {

    @Autowired
    protected TestRestTemplate restTemplate;

    /**
     * 登录单元测试
     *
     * @throws Exception
     */
    @Test
    public void login() throws Exception {
        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setMobile("12345678910");
        requestDTO.setPwd("123");
        HttpEntity<LoginRequestDTO> formEntity = new HttpEntity<>(requestDTO, new HttpHeaders());
        ResponseEntity<String> exchange = restTemplate.exchange("/member/login",
                HttpMethod.POST, formEntity, String.class);
        System.err.println(exchange.getBody());
    }

}
