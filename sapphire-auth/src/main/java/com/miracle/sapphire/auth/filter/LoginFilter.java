package com.miracle.sapphire.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author miracle
 * @date 2020/12/08
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod()
            );
        }
        if (!request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)&&!request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)) {
            throw new AuthenticationServiceException(
                    "只支持JSON"
            );
        }
        Map<String, String> loginForm = new HashMap<>();
        try {
            loginForm = new ObjectMapper().readValue(request.getInputStream(), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = loginForm.get("username");
        String password = loginForm.get("password");
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
