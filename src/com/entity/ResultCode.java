package com.entity;

/**
 * @author haoyu
 * @create 2019-03-27 22:23
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
