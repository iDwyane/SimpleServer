package com.example.test.entity.member;

import javax.validation.constraints.NotNull;

/**
 * @author lc_xin.
 * @date 2018-11-9
 */
public class LoginRequestDTO {

    @NotNull
    private String mobile;

    @NotNull
    private String pwd;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}