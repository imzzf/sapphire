package com.miracle.sapphire.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author miracle
 * @date 2020/12/05
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.miracle.sapphire.common.dao")
public class SapphireAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapphireAuthApplication.class, args);
    }

}
