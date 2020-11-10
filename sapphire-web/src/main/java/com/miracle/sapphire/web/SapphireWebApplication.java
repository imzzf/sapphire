package com.miracle.sapphire.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author miracle
 * @date 2020/11/08
 */
@SpringBootApplication
@MapperScan("com.miracle.sapphire.common.dao")
@ComponentScan({
        "com.miracle.sapphire.web",
        "com.miracle.sapphire.common"
})
public class SapphireWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapphireWebApplication.class, args);
    }

}
