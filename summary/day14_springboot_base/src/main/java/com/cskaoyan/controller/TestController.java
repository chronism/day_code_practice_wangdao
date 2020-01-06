package com.cskaoyan.controller;


import com.cskaoyan.component.FileComponent;
import com.cskaoyan.component.User;
import com.cskaoyan.component.UserDetail;
import com.cskaoyan.config.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@RestController

public class TestController {

    @Value("${file.path1111}")
    String fill;


    @Value("${db.url}")
    String url;


    @Autowired
    FileComponent fileComponent;

    @RequestMapping("hello")
    public FileComponent myTest(){
        return fileComponent;
    }

    @RequestMapping("hello_fill")
    public String myTest2(){
        return fill;
    }

    @RequestMapping("hello_url")
    public String myTest3(){
        return url;
    }





    @Autowired
    User user;
    @RequestMapping("hello_user")
    public User myTest5(){
        return user;
    }
}
