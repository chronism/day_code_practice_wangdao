package com.cskaoyan.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*   这个监听器是用来监听servlet启动，也是需要扫描包  */
@WebListener
public class WebListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener Init");
    }
}
