package com.example.test.enums;

/**
 * @author lc_xin.
 * @date 2018-11-12
 */
public enum ResponseEnum {

    SUCCESS("0000","成功"),
    ERROR("9999","服务器异常"),
    FAIL("9998","失败"),

    ;
    /**
     * 返回代码
     */
    public String responseCode;
    /**
     * 返回描述
     */
    public String responseDesc;

    ResponseEnum(String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }

    /**
     * 获取  返回代码
     *
     * @return 返回代码
     */
    public String getResponseCode() {
        return this.responseCode;
    }

    /**
     * 获取  返回描述
     *
     * @return 返回描述
     */
    public String getResponseDesc() {
        return this.responseDesc;
    }

}