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
