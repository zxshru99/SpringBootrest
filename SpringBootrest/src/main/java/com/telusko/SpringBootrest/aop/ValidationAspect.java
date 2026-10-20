package com.telusko.SpringBootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class ValidationAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution(* com.telusko.SpringBootrest.Service.JobService.*(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp,int postId) throws Throwable {
        if(postId<0){
            LOGGER.info("post id is negative");
            postId=-postId;
            LOGGER.info("updated post id is positive");

        }
        Object obj=pjp.proceed(new Object[] {postId});
        return obj;

    }

}
