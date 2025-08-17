package com.saketsatpute.multitenancy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TenantLoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(TenantLoggingAspect.class);

    @Before("execution(* com.saketsatpute.multitenancy.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering method: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.saketsatpute.multitenancy.controller..*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Exiting method: {} with result: {}", joinPoint.getSignature(), result);
    }
}
