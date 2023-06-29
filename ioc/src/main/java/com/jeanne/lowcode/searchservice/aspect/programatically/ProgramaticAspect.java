package com.jeanne.lowcode.searchservice.aspect.programatically;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Jeanne 2023/5/30
 **/
@Aspect
@Slf4j
public class ProgramaticAspect {
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
