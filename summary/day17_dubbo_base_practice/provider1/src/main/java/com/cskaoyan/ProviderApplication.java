package com.cskaoyan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class ProviderApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        applicationContext.start();

        System.in.read();
    }
}
