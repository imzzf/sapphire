package com.miracle.sapphire.common.exception;

import com.miracle.sapphire.common.api.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author miracle
 * @date 2020/11/07
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public Result handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return Result.failed(e.getErrorCode());
        }
        return Result.failed(e.getMessage());
    }


    public String defaultExceptionHandler(HttpServletRequest request, Exception e) {
        return "error";
    }

}
