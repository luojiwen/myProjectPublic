package com.spring.boot.aop.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(-100) //这是为了保证AOP在事务注解之前生效,Order的值越小,优先级越高
public class ServiceMethodAspect {

    @Pointcut("execution(* com.spring.boot.aop.service.SampleService.compute(..))")
    private void doComputeAspectPointcut() {
    }

    @Before("doComputeAspectPointcut()")
    public void doComputeBeforeAdvice() {
        log.debug("=== ServiceMethodAspect do Compute Before");
    }

    @AfterReturning("doComputeAspectPointcut()")
    public void doComputeAfterReturningAdvice() {
        log.debug("=== ServiceMethodAspect do Compute After Returning");
    }

    @AfterThrowing("doComputeAspectPointcut()")
    public void doComputeAfterThrowingAdvice() {
        log.debug("=== ServiceMethodAspect do Compute After Throwing");
    }

}
