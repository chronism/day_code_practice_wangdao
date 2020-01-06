package com.cskaoyan;

import org.springframework.stereotype.Component;

@Component
public class TestMethod {
    public void sayHello(int i){
        System.out.println("我是测试方法:"+i);
    }
}
