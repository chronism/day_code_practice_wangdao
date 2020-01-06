package com.cskaoyan.web;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


     /*  第一种方式，注解方式配置Filter，这个需要在启动类里面配置扫描包扫描这个，才能起作用*/
@WebFilter("/*")
public class HelloFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hellofilter1");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
