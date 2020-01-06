package com.cskaoyan;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomProxy  {

@Pointcut(value = "execution(public void com.cskaoyan.TestMethod.*(int))")
public void myPointCut(){

}

    @Before(value = "myPointCut()")
    public void mybefore(JoinPoint joinpoint){
        System.out.println("before");
    }

    @After("myPointCut()")
    public void myafter(JoinPoint joinpoint){
        System.out.println("after");
    }

    @Around("myPointCut()")
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

    @AfterReturning(value = "myPointCut()",returning = "o")
    public void afterReturning(Object o){
        System.out.println("afterreturning"+o);;
    }

    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void afterThrowing(Exception e){
        e.getMessage();
    }



}
