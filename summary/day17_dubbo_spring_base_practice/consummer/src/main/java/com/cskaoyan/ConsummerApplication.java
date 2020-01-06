package com.cskaoyan;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.cskaoyan.consummer.ThirdBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubboConfiguration
public class ConsummerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConsummerApplication.class, args);
        ThirdBean thirdBean = applicationContext.getBean(ThirdBean.class);
        String yuanchuan = thirdBean.sayHello("yuanchuan");
        System.out.println(yuanchuan);


    }

}
