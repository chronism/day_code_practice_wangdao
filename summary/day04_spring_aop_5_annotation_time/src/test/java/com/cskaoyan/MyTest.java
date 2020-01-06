package com.cskaoyan;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MyTest {
    @Autowired
    TestMethod testMethod;

    @Test
    public void myTest() throws InterruptedException {
        testMethod.sayHello2(23);
    }
}
