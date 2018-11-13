package com.example.test.entity.member;

/**
 * @author lc_xin.
 * @date 2018-11-9
 */
public class LoginResponseDTO {

    private String mobile;

    private String name;

    private String pwd;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) { this.pwd = pwd; }
}