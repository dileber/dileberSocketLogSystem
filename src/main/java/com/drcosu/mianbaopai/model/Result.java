package com.drcosu.mianbaopai.model;

import java.io.Serializable;

/**
 * Created by DELL on 2017/11/1.
 */
public class Result implements Serializable{
    Integer code;
    String message;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
