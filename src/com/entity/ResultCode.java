package com.entity;

/**
 * @Acthor:孙琪; date:2019/4/2;
 */
public class ResultCode {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultCode() {
    }

    public ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
