package com.mio4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
public class LogAspect {
    private static final Logger logger =LoggerFactory.getLogger(LogAspect.class);


    @Before("execution(* com.mio4.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuffer sb = new StringBuffer();
        for(Object arg : joinPoint.getArgs()){
            sb.append(" arg:" + arg.toString() + "|");
        }
        logger.info("before method" + sb.toString());
        //logger.info("time",new Date());
    }

    @After("execution(* com.mio4.controller.IndexController.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        logger.info("after method");
    }
}
