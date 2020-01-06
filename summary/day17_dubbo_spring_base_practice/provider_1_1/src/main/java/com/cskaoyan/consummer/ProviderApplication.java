package com.cskaoyan.consummer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
@EnableDubboConfiguration
public class ProviderApplication {

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderApplication.class, args);
        applicationContext.start();

        System.in.read();
    }

}
