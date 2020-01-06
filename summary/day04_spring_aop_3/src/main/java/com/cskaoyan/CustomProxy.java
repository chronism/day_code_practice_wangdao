package com.cskaoyan;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomProxy  {


    public void mybefore(JoinPoint joinpoint){
        System.out.println("before");
    }

    public void myafter(JoinPoint joinpoint){
        System.out.println("after");
    }


    /*  记住这里是 ProceedingJoinPoint  */
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try {
            System.out.println("around 前");
            proceed = joinPoint.proceed();
            System.out.println("around 后");
        } catch (Exception e) {
            e.getMessage();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    /*  必须和前面的xml的返回值一一对应 */
    public void afterReturning(Object o){
        System.out.println(o);;
    }

    public void afterThrowing(Exception e){
        e.getMessage();
    }



}
