package com.cskaoyan.config;


import com.cskaoyan.web.HelloFilter2;
import com.cskaoyan.web.HelloServlet2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

@Configuration
public class HelloConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new HelloServlet2());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("/hello/servlet2");
        servletRegistrationBean.setUrlMappings(strings);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HelloFilter2());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("/*");
        filterRegistrationBean.setUrlPatterns(arrayList);
        return filterRegistrationBean;
    }


}
