package com.miracle.sapphire.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miracle
 * @date 2020/11/08
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public String health(){
        return "TEST IS OK";
    }
}
