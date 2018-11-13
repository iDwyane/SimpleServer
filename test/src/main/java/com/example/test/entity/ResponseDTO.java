package com.example.test.entity;

import com.example.test.enums.ResponseEnum;

import java.io.Serializable;

/**
 * @author lc_xin.
 * @date 2018-11-12
 */
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = -4109110629830724000L;
    /**
     * 响应code
     */
    private String responseCode;
    /**
     * 响应描述
     */
    private String responseDesc;
    /**
     * 响应的内容
     */
    private T data;

    private ResponseDTO() {
    }

    public ResponseDTO(ResponseEnum responseEnum) {
        this(responseEnum, null);

    }

    public ResponseDTO(String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }

    public ResponseDTO(T data, ResponseEnum responseEnum) {
        this(responseEnum);
        this.data = data;
    }

    public ResponseDTO(T data, String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
        this.data = data;
    }

    public ResponseDTO(ResponseEnum responseEnum, String extend) {
        if (responseEnum != null) {
            this.responseCode = responseEnum.getResponseCode();
            this.responseDesc = responseEnum.getResponseDesc() + (extend == null ? "" : "(" + extend + ")");
        }
    }

    public static <T> ResponseDTO<T> buildSuccess(T data) {
        return new ResponseDTO<>(data, ResponseEnum.SUCCESS);
    }

    public static <T> ResponseDTO<T> buildSuccess() {
        return new ResponseDTO<>(ResponseEnum.SUCCESS);
    }

    public static <T> ResponseDTO<T> buildFail() {
        return new ResponseDTO<>(ResponseEnum.FAIL);
    }

    public static <T> ResponseDTO<T> buildError() {
        return new ResponseDTO<>(ResponseEnum.ERROR);
    }

    public static <T> ResponseDTO<T> buildEnum(T data, ResponseEnum responseEnum) {
        return new ResponseDTO<>(data, responseEnum);
    }

    public static <T> ResponseDTO<T> buildEnum(ResponseEnum responseEnum) {
        return new ResponseDTO<>(responseEnum);
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return this.responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T date) {
        this.data = date;
    }
}