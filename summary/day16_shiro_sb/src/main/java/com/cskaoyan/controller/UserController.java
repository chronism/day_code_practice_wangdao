package com.cskaoyan.controller;

import com.cskaoyan.bean.UserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
public class UserController {

   /* @RequestMapping("aaa")
//    @ResponseBody
    public String index() {

        return "index";
    }*/

    @RequestMapping(value = "/aaa")
    public String index() {

        return "index"; //templates/index.ftlh
    }

    @RequestMapping("unAuthc")
    public String unAuth() {

        return "forward:/aaa";
    }

    @RequestMapping("admin/login")
    public String adminLogin(String username, String password) {
        UserToken admin = new UserToken(username, password, "admin");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(admin);
            boolean authenticated = subject.isAuthenticated();
        } catch (AuthenticationException e) {
            return "forward:/aaa";
        }
        return "success";
        /*Serializable id = subject.getSession().getId();
        return (String) id;*/
    }

    @RequestMapping("wx/login")
    public String wxLogin(String username, String password) {
        UserToken wx = new UserToken(username, password, "wx");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(wx);
            boolean authenticated = subject.isAuthenticated();
        } catch (AuthenticationException e) {
            return "forward:/aaa";
        }
        return "success";
        /*Serializable id = subject.getSession().getId();
        return (String) id;*/
    }

    @RequestMapping("success")
    public String success() {

        return "success";
    }

    /*
     * need/perm
     * 使用这个RequiresPermissions需要aspectj支持
     * 引入aspectjweaver的支持包
     * 需要注册一个advisor
     * */
    @RequestMapping("school/appoint")
    @RequiresPermissions(value = {"appoint", "command"}, logical = Logical.OR)
    public String needPerm() {
        Subject subject = SecurityUtils.getSubject();
        //Object primaryPrincipal = subject.getPrincipals().getPrimaryPrincipal();
//        User user = (User) subject.getPrincipal();

        return "permission";
    }

    @RequestMapping("noperm")
    public String noperm() {

        return "noperm";
    }

    /*注销*/
    @RequestMapping("auth/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/aaa";
    }
}
