package com.example.test.controller;

import com.example.test.entity.ResponseDTO;
import com.example.test.entity.member.LoginRequestDTO;
import com.example.test.entity.member.LoginResponseDTO;
import com.example.test.enums.ResponseEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lc_xin.
 * @date 2018-11-12
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @PostMapping("/login")
    public ResponseDTO<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO requestDTO) throws Exception{
        //todo 校验账号密码

        //校验好了，返回用户信息给到客户端
        LoginResponseDTO response = new LoginResponseDTO();
        response.setMobile(requestDTO.getMobile());
        response.setName("test");
        response.setPwd(requestDTO.getPwd());
        return new ResponseDTO<>(response, ResponseEnum.SUCCESS);
    }

}