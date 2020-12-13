package com.miracle.sapphire.common.api;

/**
 * @author miracle
 * @date 2020/11/07
 */
public enum ResultCode implements IErrorCode {

    //操作失败
    FAILED(0, "操作失败"),

    //操作成功
    SUCCESS(1, "操作成功"),

    //USER模块
    USER_UNAUTH(1000, "用户未登录"),
    USER_USERNAME_REGISTERED(1001, "该用户名已经被注册了"),
    USER_USERNAME_NOT_EXISTED(1002, "用户名不存在"),

    ;

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
