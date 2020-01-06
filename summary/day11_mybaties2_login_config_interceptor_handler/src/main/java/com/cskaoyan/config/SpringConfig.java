package com.cskaoyan.config;



import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*  Spring配置 */
@Configuration
@ComponentScan(value="com.cskaoyan",
excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = {Controller.class, EnableWebMvc.class})})

//@EnableAspectJAutoProxy

public class SpringConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }
}
