package com.cskaoyan.controller;

import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;



    @RequestMapping("/user/id/{id}")
    public String queryUserNameById(@PathVariable("id")String id){
        String s = userService.queryUserNameById(Integer.parseInt(id));
        return s;
    }

}
