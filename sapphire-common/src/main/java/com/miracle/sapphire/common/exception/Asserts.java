package com.miracle.sapphire.common.exception;

import com.miracle.sapphire.common.api.IErrorCode;

/**
 * @author miracle
 * @date 2020/11/07
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

}
