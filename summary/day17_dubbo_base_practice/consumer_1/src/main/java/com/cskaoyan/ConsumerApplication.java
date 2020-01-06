package com.cskaoyan;

import com.cskaoyan.service.DubboDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        /*这个application不能直接从JavaBean的类中得到实例*/
        applicationContext.start();
        DubboDemoService dubboDemoService = (DubboDemoService) applicationContext.getBean("dubboDemoService");
        for (int i = 0; i < 10; i++) {
            String yuanchuan = dubboDemoService.sayHello("yuanchuan");
            System.out.println(yuanchuan);

        }

    }
}
