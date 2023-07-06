package com.example.transactionmybatisdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/5/29
 **/
@Aspect
@Slf4j
@Component
public class ProfilingAspect {

    @Pointcut("target(com.example.transactionmybatisdemo.service.DemoService) && execution(* methodTransaction(..))") // the pointcut expression
    private void profiling() {
    } // the pointcut signature

    @Around("profiling()")
    @AdviceName("profiling")
    public Object profilingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("<--------------profiling-------------->" );
        Object r = joinPoint.proceed();
        log.info("<-----------------profiling---------->");

        return r;
    }





}
