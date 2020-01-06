package com.cskaoyan.controller;

import com.cskaoyan.domain.User;
import com.cskaoyan.service.UserServicea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @Autowired
    UserServicea userService;

    @RequestMapping("/user/id/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id")Integer id){
        User user = userService.queryUserById(id);
        return user;
    }


    @RequestMapping("/user/freemarker")
    public ModelAndView freeMarker(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key","freemarker");
        modelAndView.setViewName("freemarker");
        return modelAndView;
    }


}
