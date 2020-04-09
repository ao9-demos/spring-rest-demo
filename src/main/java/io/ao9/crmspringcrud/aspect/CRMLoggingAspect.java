package io.ao9.crmspringcrud.aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* io.ao9.crmspringcrud.controller.*.*(..))")
    private void forControllerPackage() {        
    }

    @Pointcut("execution(* io.ao9.crmspringcrud.service.*.*(..))")
    private void forServicePackage() {        
    }

    @Pointcut("execution(* io.ao9.crmspringcrud.dao.*.*(..))")
    private void forDaoPackage() {        
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {        
    }

    @Before("forAppFlow()")
    public void beforeAppFlowAdvice(JoinPoint theJoinPoint) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("==== @Before: the method is " + theMethod);

        Object[] args = theJoinPoint.getArgs();
        logger.info("==== @Before: the args are " + Arrays.asList(args));
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterAppFlowAdvice(JoinPoint theJoinPoint, Object theResult) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("==== @AfterReturning: the method is " + theMethod);

        logger.info("==== @AfterReturning: the returning theResult is " + theResult);
    }

}