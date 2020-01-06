package com.cskaoyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@ComponentScan("com.cskaoyan.controller")
public class WebMvcConfig implements WebMvcConfigurer {

}
