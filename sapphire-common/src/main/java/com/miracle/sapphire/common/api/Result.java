package com.miracle.sapphire.common.api;

import java.io.Serializable;

/**
 * @author miracle
 * @date 2020/11/07
 */
public class Result implements Serializable {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    private Result() {
    }

    private Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回，无数据
     */
    public static Result success() {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回，自定义信息
     */
    public static Result success(String message) {
        return new Result(ResultCode.SUCCESS.getCode(), message, null);
    }

    /**
     * 成功返回，有数据
     */
    public static Result success(Object data) {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回，根据枚举类
     */
    public static Result failed(IErrorCode iErrorCode) {
        return new Result(iErrorCode.getCode(), iErrorCode.getMessage(), null);
    }

    /**
     * 失败返回，自定义信息
     */
    public static Result failed(String message) {
        return new Result(ResultCode.FAILED.getCode(), message, null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
