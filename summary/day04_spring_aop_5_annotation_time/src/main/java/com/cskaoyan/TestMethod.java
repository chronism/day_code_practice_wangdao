package com.cskaoyan;

import org.springframework.stereotype.Component;

@Component
public class TestMethod {
    public void sayHello(int i){
        System.out.println("我是测试方法111111");
    }


    @TimeCost
    public void sayHello2(int i) throws InterruptedException {
        Thread.sleep(6000);
        System.out.println("我是测试方法2222222");
    }
}
