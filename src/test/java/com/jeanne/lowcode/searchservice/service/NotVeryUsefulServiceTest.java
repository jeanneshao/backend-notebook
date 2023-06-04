package com.jeanne.lowcode.searchservice.service;

import com.jeanne.lowcode.searchservice.aspect.NotVeryUsefulAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

/**
 * @author Jeanne 2023/6/1
 **/
@Slf4j
@SpringBootTest
class NotVeryUsefulServiceTest {
    @Resource
//    NotVeryUsefulService notVeryUsefulService;
    NotVeryUsefulInterface notVeryUsefulService;

    @Resource
    ApplicationContext context;

    @Test
    void transfer() {
        notVeryUsefulService.transfer();
    }

    @Test
    void testTransfer() {
        log.info("<----------------ok example----------------------->");

        notVeryUsefulService.transfer(1);
        log.info("<----------------error example----------------------->");

        notVeryUsefulService.transfer(-1);

    }

    @Test
    public void testWithin(){
        notVeryUsefulService.within();
    }
    @Test
    public void testthisDemo(){
        final NotVeryUsefulInterface bean = context.getBean(NotVeryUsefulInterface.class);
        System.out.println("类名称："+bean.getClass().getName());
        System.out.println("bean instanceof IndexDao :"+(bean instanceof NotVeryUsefulInterface));
        System.out.println("bean instanceof IndexDaoImpl :"+(bean instanceof NotVeryUsefulService));
        System.out.println("bean instanceof Proxy :"+(bean instanceof Proxy));
        bean.thisDemo();

//        notVeryUsefulService.thisDemo();
    }

    @Test
    public void testAopProgramatically2(){
        NotVeryUsefulService serviceObj = new NotVeryUsefulService();
        NotVeryUsefulAspect programaticAspect = new NotVeryUsefulAspect();
        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(serviceObj);

        proxyFactory.addAspect(programaticAspect);
        NotVeryUsefulInterface proxy = proxyFactory.getProxy();
        System.out.println(proxy.getClass().getName());
        proxy.thisDemo();
        System.out.println("<============force cglib===================>");

        proxyFactory.setProxyTargetClass(true);//是否需要使用CGLIB代理
         proxy = proxyFactory.getProxy();
        System.out.println(proxy.getClass().getName());
        proxy.thisDemo();
    }
}