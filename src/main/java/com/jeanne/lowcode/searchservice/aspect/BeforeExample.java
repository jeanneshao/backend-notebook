package com.jeanne.lowcode.searchservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/5/29
 **/
@Aspect
@Slf4j
@Component

public class BeforeExample {
    //        @Around("execution( * com..*.service..*.*(..))&& args(..)")
//    @Around("execution( * com..*.service..*.dataAccessOperation(..))&& args(..)")
//    @Around("execution( * com..*.service..*.dataAccessOperation(..))&& args(..,count)")
//    public void doAccessCheck(ProceedingJoinPoint joinPoint, int count) {
//        log.info("<-----------------BeforeExample doAccessCheck-------------{}---------->", count);
//    }
//
//    @Around("execution( * com..*.service..*.dataAccessOperation(..))&& args(..,count,name)")
//    public void doAccessCheck(ProceedingJoinPoint joinPoint, int count, String name) {
//        log.info("<-----------------BeforeExample 2 params----------------------->{}----{}", count, name);
//    }

    @Before("execution( * com..*.service..*.dataAccessOperation(..))")
    public void doAccessBefore( ) {
        log.info("<-----------------doAccessBefore ignore params----------------------->");
    }

    @Before("execution( * com..*.service..*.dataAccessOperation(..))&& args(..,count,name)")
    public void doAccessBefore( int count, String name) {
        log.info("<-----------------doAccessBefore 2 params----------------------->{}----{}", count, name);
    }

    @Before("execution(* com.jeanne.lowcode.searchservice.service.*.*(..))")
    public void beforeAction() {
        log.info("<-----------------BeforeExample beforeAction----------------------->");

    }
}
