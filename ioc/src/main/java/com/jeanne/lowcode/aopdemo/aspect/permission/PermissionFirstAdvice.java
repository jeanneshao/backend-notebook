package com.jeanne.lowcode.aopdemo.aspect.permission;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/5/29
 **/
@Aspect
@Component
@Slf4j
public class PermissionFirstAdvice {
    // 定义一个切面，括号内写入第1步中自定义注解的路径
    @Pointcut("@annotation(com.jeanne.lowcode.aopdemo.aspect.permission.PermissionAnnotation)")
    private void permissionCheck() {
    }


    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===================before around===================：" + System.currentTimeMillis());

        Object r = joinPoint.proceed();
        System.out.println("===================after around===================：" + System.currentTimeMillis());

        return r;
    }

    @Before("permissionCheck()")
    public void beforePermissionCheck() throws Throwable {
        System.out.println("===================before Before===================：" + System.currentTimeMillis());

    }

    @After("permissionCheck()")
    public void afterPermissionCheck() throws Throwable {
        System.out.println("===================after===================：" + System.currentTimeMillis());

    }



}
