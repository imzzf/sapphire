package com.miracle.sapphire.auth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.sapphire.common.api.Result;
import com.miracle.sapphire.common.api.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author miracle
 * @date 2020/12/08
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Result result=Result.failed(ResultCode.USER_UNAUTH);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
