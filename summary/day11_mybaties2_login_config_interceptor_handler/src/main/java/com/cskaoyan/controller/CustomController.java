package com.cskaoyan.controller;


import com.cskaoyan.domain.User;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping("/user/login")
    public String userLogin(HttpServletRequest httpRequest, User user){
        HttpSession session = httpRequest.getSession();
        if(user==null && !"true".equals(session)){
            return "/login.jsp";
        }
        if(user!=null){
            Boolean flag = customService.queryUser(user);
            if(flag){
                session.setAttribute("login_state","true");
                return "/WEB-INF/resources/private.jsp";
            }else {
                return "/login.jsp";
            }
        }
        return null;
    }

    @RequestMapping("/user/visit")
    public String userVisitResource(){
        return "/WEB-INF/resources/private.jsp";
    }
}
