package com.jeanne.lowcode.searchservice.aspect.introduction;

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
    @DeclareParents(value = "com.jeanne.lowcode.searchservice.service.CommonPointcuts", defaultImpl = DemoInterfaceImpl.class)
    private DemoInterface demoInterface;

}
