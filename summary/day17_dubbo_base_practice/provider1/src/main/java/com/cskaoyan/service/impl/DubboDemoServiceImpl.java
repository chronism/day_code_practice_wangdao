package com.cskaoyan.service.impl;


import com.cskaoyan.service.DubboDemoService;
import org.springframework.stereotype.Service;

@Service
public class DubboDemoServiceImpl implements DubboDemoService {
    @Override
    public String sayHello(String someWords) {

        return "provider11111111为您服务："+someWords;
    }
}
