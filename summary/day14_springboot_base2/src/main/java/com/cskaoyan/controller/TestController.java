package com.cskaoyan.controller;



import com.cskaoyan.component.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {


    @Autowired
    User user;

    @RequestMapping("/hello_user")
    public User myTest5(){
        System.out.println("hello");
        return user;

    }
}
