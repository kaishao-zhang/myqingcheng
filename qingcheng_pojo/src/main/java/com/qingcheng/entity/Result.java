package com.qingcheng.entity;

import java.io.Serializable;

/**
 * @author 凯少
 * @create 2019-11-19 20:23
 */
public class Result implements Serializable {
    private  Integer code;//返回的业务码，0：执行成功，1：执行失败
    private String message;//信息

    public Result() {
        this.code = 0;
        this.message ="执行成功";
    }

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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
