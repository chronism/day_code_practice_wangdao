package com.cskaoyan.consummer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.service.DemoService;
import org.springframework.stereotype.Component;

@Component
public class ThirdBean {

//    @Reference(interfaceClass = DemoService.class,check = false,url = "dubbo://localhost:20880")
    @Reference(interfaceClass = DemoService.class,check = false)
    DemoService demoService;

    public String sayHello(String words){

        return demoService.sayHello(words);
    }
}
