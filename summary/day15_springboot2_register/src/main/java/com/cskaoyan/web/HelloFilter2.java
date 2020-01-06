package com.cskaoyan.web;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/* 第二种方式配置，需要借助Configuration，注册一下*/
public class HelloFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hellofilter2");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
