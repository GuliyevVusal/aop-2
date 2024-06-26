package com.example.aop.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RestControllerLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(RestControllerLoggingAspect.class);

    @Before("execution(* com.example.aop.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String arguments = Arrays.toString(joinPoint.getArgs());
        logger.info("Entering method: {}() with arguments: {}", methodName, arguments);
    }

    @AfterReturning(pointcut = "execution(* com.example.aop.controller.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method {}() returned with value: {}", methodName, result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.aop.controller.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Exception in method {}(): {}", methodName, exception.getMessage());
    }
}
