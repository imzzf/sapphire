package com.miracle.sapphire.auth.config;

import com.miracle.sapphire.auth.filter.LoginFilter;
import com.miracle.sapphire.auth.handler.MyAuthenticationFailureHandler;
import com.miracle.sapphire.auth.handler.MyAuthenticationSuccessHandler;
import com.miracle.sapphire.auth.handler.MyLogoutSuccessHandler;
import com.miracle.sapphire.auth.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author miracle
 * @date 2020/12/06
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        loginFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/login");
        return loginFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/user/login").permitAll()
                .anyRequest().authenticated()
                //登出
                .and().logout()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .deleteCookies("sapphire-auth-session")

                //异常处理 无权访问
                .and().exceptionHandling()
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                .and()
                .csrf().disable()
                .addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class)
                .cors()
        ;
    }
}
