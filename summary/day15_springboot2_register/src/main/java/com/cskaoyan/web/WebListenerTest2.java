package com.cskaoyan.web;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*   这个监听器是用来监听servlet启动，也是需要扫描包  */
@Component
public class WebListenerTest2 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener Init2");
    }
}
