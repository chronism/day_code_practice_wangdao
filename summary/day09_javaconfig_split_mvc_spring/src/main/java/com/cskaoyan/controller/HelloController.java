package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    /*初始化会显示在控制台*/
    public HelloController() {
        System.out.println("controller init");
    }
}
