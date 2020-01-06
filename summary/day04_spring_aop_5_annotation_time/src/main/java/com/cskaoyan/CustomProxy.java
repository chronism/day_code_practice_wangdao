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


@Pointcut("@annotation(TimeCost)")
public void myPointCut2(){

}

    @Before(value = "myPointCut2()")
    public void mybefore(JoinPoint joinpoint){
        System.out.println("before");
    }

    @After("myPointCut2()")
    public void myafter(JoinPoint joinpoint){
        System.out.println("after");

    }

    @Around("myPointCut2()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try {
            System.out.println("around 前");
            long l = System.currentTimeMillis();
            proceed = joinPoint.proceed();
            long ll = System.currentTimeMillis();
            System.out.println(ll-l);
            System.out.println("around 后");
        } catch (Exception e) {
            e.getMessage();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    @AfterReturning(value = "myPointCut2()",returning = "o")
    public void afterReturning(Object o){
        System.out.println("afterreturning"+o);;
    }

    @AfterThrowing(value = "myPointCut2()",throwing = "e")
    public void afterThrowing(Exception e){
        e.getMessage();
    }



}
