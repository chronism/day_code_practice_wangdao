package com.cskaoyan.dao.impl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class CustomAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before");
        String name = methodInvocation.getMethod().getName();
        System.out.println("methodName:"+name);

        Object[] arguments = methodInvocation.getArguments();
        System.out.println("arguments:"+Arrays.toString(arguments));
        Object proceed = methodInvocation.proceed();
        System.out.println("after");
        return proceed;
    }
}
