package com.telusko.SpringBootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public static final Logger LOGGER =
            LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.telusko.SpringBootrest.Service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called: " + jp.getSignature().getName());
    }
    @After("execution(* com.telusko.SpringBootrest.Service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method executed"+jp.getSignature().getName());
    }
}