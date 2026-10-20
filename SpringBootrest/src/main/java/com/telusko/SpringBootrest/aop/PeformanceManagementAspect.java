package com.telusko.SpringBootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PeformanceManagementAspect {

    public static final Logger LOGGER =
            LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution(* com.telusko.SpringBootrest.Service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {

        long start=System.currentTimeMillis();
        Object obj=pjp.proceed();
        long end=System.currentTimeMillis();
        LOGGER.info(("Time taken")+(start-end)+"ms");
        return obj;

    }



}
