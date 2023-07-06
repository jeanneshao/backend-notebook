package com.jeanne.lowcode.aopdemo.aspect.introduction;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/5/30
 **/
@Aspect
@Component
@Slf4j
public class IntroductionDemoAspect {
    @DeclareParents(value = "com.jeanne.lowcode.aopdemo.service.PermissionService", defaultImpl = DemoInterfaceImpl.class)
    private DemoInterface demoInterface;

}
