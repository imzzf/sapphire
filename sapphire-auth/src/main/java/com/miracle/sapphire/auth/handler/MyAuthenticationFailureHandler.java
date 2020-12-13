package com.miracle.sapphire.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.sapphire.common.api.Result;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author miracle
 * @date 2020/12/07
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        Result result = Result.failed("登录失败");
        if (e instanceof UsernameNotFoundException) {
            result = Result.failed("用户名错误");
        } else if (e instanceof BadCredentialsException) {
            result = Result.failed("密码错误");
        }
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
