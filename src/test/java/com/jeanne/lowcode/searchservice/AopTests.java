package com.jeanne.lowcode.searchservice;

import com.jeanne.lowcode.searchservice.aspect.aspectj.Account;
import com.jeanne.lowcode.searchservice.aspect.aspectj.ShouldBeConfiguredBySpring;
import com.jeanne.lowcode.searchservice.aspect.introduction.DemoInterface;
import com.jeanne.lowcode.searchservice.aspect.programatically.ProgramaticAspect;
import com.jeanne.lowcode.searchservice.config.AopConfig;
import com.jeanne.lowcode.searchservice.service.CommonPointcuts;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class AopTests {
    @Resource
    CommonPointcuts commonPointcuts;

    @Resource
    ApplicationContext context;

    @Test
    public void testAop() {
        commonPointcuts.dataAccessOperation();
    }


    @Test
    public void testAop1() {
        commonPointcuts.dataAccessOperation(32);
        commonPointcuts.dataAccessOperation(32, "hello");
    }


    @Test
    public void testIntroduction() {
        DemoInterface pointcutInterface = (DemoInterface) this.commonPointcuts;
        pointcutInterface.run();
    }

    @Test
    public void testAopProgramatically() {
        CommonPointcuts serviceObj = new CommonPointcuts();
        ProgramaticAspect programaticAspect = new ProgramaticAspect();
        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(serviceObj);

//        proxyFactory.addAspect(ProgramaticAspect.class);
        proxyFactory.addAspect(programaticAspect);

//        proxyFactory.setProxyTargetClass(true);//是否需要使用CGLIB代理
        CommonPointcuts proxy = proxyFactory.getProxy();
        proxy.dataAccessOperation(22,"abd");

    }

    @Test
    public void testAspectJ(){
        Account account = context.getBean(Account.class);
        account.callService();

//        account = new Account();
//        account.callService();
    }


}
