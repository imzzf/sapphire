package com.miracle.sapphire.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author miracle
 * @date 2020/11/08
 */
@SpringBootApplication(scanBasePackages = "com.miracle.sapphire")
@EnableDiscoveryClient
@MapperScan("com.miracle.sapphire.common.dao")
public class SapphireWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapphireWebApplication.class, args);
    }

}
