package com.miracle.sapphire.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author miracle
 * @date 2020/12/09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SapphireGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapphireGatewayApplication.class, args);
    }
}
