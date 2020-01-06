package com.cskaoyan;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class CustomProxy implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MethodInvocation在执行");
        Object proceed = methodInvocation.proceed();
        return proceed;
    }

}
