package com.jeanne.lowcode.searchservice.aspect.permission;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * @author Jeanne 2023/5/29
 **/
@Aspect
@Component
@Slf4j
public class PermissionFirstAdvice {
    // 定义一个切面，括号内写入第1步中自定义注解的路径
    @Pointcut("@annotation(com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation)")
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



}
