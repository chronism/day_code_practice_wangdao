package com.cskaoyan.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

@Component
public class ComplexException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object handler, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MyException) {
            modelAndView.setViewName("/WEB-INF/error.jsp");
            modelAndView.addObject("message", ((MyException) e).getMyExceptionMessage());
        }else {
         modelAndView.setViewName("/WEB-INF/error2.jsp");
         modelAndView.addObject("message","这错误我只是想测一下");
        }
        return modelAndView;
    }
}
