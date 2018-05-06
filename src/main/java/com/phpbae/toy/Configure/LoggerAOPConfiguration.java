package com.phpbae.toy.Configure;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAOPConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(LoggerAOPConfiguration.class);
    private Signature signature;
    private Object target;

    @Before(value = "execution(* com.phpbae.toy.Service.*.*(..))")
    public void beforeLogger(JoinPoint joinPoint) {
        signature = joinPoint.getSignature();
        target = joinPoint.getTarget();
        logger.info(signature.getName() + " Start Process");
    }

    @After(value = "execution(* com.phpbae.toy.Service.*.*(..))")
    public void afterLogger(JoinPoint joinPoint) {
        signature = joinPoint.getSignature();
        target = joinPoint.getTarget();
        logger.info(signature.getName() + " End Process");
    }

}
