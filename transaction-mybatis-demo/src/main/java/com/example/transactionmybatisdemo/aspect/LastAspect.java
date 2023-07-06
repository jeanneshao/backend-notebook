package com.example.transactionmybatisdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/5/29
 **/
@Aspect
@Slf4j
@Component
@Order()
public class LastAspect {

    @Pointcut("target(com.example.transactionmybatisdemo.service.DemoService) && execution(* methodTransaction(..))") // the pointcut expression
    private void shouldBeLast() {
    } // the pointcut signature

    @Around("shouldBeLast()")
    @AdviceName("profiling")
    public Object shouldBeLastAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("<--------------profiling-------------->" );
        Object r = joinPoint.proceed();
        log.info("<-----------------profiling---------->");

        return r;
    }





}
