package com.cskaoyan.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionControllerAdvise {

    @ExceptionHandler({AuthorizationException.class})
    /*可以返回Json或者视图解析器*/
    @ResponseBody
    public String handlerAuthorException(Exception e) {

        return "noperm"; //ModelAndView
    }
}
