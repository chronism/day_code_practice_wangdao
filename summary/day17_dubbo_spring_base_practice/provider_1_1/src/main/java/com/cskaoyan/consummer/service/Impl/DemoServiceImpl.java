package com.cskaoyan.consummer.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.service.DemoService;
import org.springframework.stereotype.Component;


@Component
@Service(interfaceClass=DemoService.class)
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String words) {
        return "您好："+words;
    }
}
