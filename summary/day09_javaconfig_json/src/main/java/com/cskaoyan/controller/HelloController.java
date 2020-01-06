package com.cskaoyan.controller;
import com.cskaoyan.bean.UserDetail;

import com.cskaoyan.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@Controller
/*定义全局的返回值类型都是Json*/
@RestController
public class HelloController {

    @RequestMapping("hello")
    //@ResponseBody
    public User hello(){

        User user = new User();
        user.setUsername("heidashuai");
        user.setPassword("黑大帅");
        user.setAge(30);
        UserDetail userDetail = new UserDetail();
        userDetail.setEmail("heidashuai@cskaoyan.com");
        userDetail.setGender("male");

        user.setUserDetail(userDetail);

        return user;
    }

    @RequestMapping("hello2")
    public String hello2(){
        return "hello2";
    }

    @RequestMapping("register")
    //username=xxx&password=xxx&age=xxx&userDetail.email=XXX&userDetail.gender=xxx
    public String register(@RequestBody User user){

        System.out.println(user);
        return "ok";

    }
    @RequestMapping("register2")
    public String register2(@RequestBody Map map){

        return "ok";
    }
}
