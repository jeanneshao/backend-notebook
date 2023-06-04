package com.jeanne.lowcode.searchservice;

import com.jeanne.lowcode.searchservice.aspect.aspectj.Account;
import com.jeanne.lowcode.searchservice.aspect.introduction.DemoInterface;
import com.jeanne.lowcode.searchservice.aspect.programatically.ProgramaticAspect;
import com.jeanne.lowcode.searchservice.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class AopTests {
    @Resource
    PermissionService permissionService;

    @Resource
    ApplicationContext context;

    @Test
    public void testAop() {
        permissionService.dataAccessOperation();
    }


    @Test
    public void testAop1() {
        permissionService.dataAccessOperation(32);
        permissionService.dataAccessOperation(32, "hello");
    }


    @Test
    public void testIntroduction() {
        DemoInterface pointcutInterface = (DemoInterface) this.permissionService;
        pointcutInterface.run();
    }

    @Test
    public void testAopProgramatically() {
        PermissionService serviceObj = new PermissionService();
        ProgramaticAspect programaticAspect = new ProgramaticAspect();
        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(serviceObj);

//        proxyFactory.addAspect(ProgramaticAspect.class);
        proxyFactory.addAspect(programaticAspect);

//        proxyFactory.setProxyTargetClass(true);//是否需要使用CGLIB代理
        PermissionService proxy = proxyFactory.getProxy();
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
