package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;


@Component
@Aspect
public class TransactionAop {


    @Pointcut(value = "execution(* service.impl.TransMoneyServiceImpl.transMoney(..))")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = null;
        Object proceed = null;
        try {
            connection = DruidUtils.getConnection(false);
            connection.setAutoCommit(false);
            proceed = joinPoint.proceed();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            DruidUtils.restoreConnection();
        }
        return proceed;
    }
}