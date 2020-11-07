package com.miracle.sapphire.common.api;

/**
 * @author miracle
 * @date 2020/11/07
 */
public interface IErrorCode {

    /**
     * 获取返回码
     */
    Integer getCode();

    /**
     * 获取返回信息
     */
    String getMessage();
}
