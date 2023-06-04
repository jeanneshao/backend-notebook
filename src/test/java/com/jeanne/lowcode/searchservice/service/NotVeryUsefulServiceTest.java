package com.jeanne.lowcode.searchservice.service;

import com.jeanne.lowcode.searchservice.aspect.NotVeryUsefulAspect;
import com.jeanne.lowcode.searchservice.config.AopConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.LifecycleProcessor;
import org.springframework.web.context.support.StandardServletEnvironment;

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
    AopConfig aopConfig;

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
        System.out.println("<============类名称："+notVeryUsefulService.getClass().getName());
        notVeryUsefulService.thisDemo();
    }

    @Resource
    LifecycleProcessor lifecycleProcessor;
    @Resource
    StandardServletEnvironment environment;
    @Resource
    ServletContextInitializer servletContextInitializer;
    @Resource
    ProxyConfig proxyConfig;
    @Resource
    AbstractAutoProxyCreator proxyCreator;
//    @Resource
//    ProxyFactory proxyFactory;

    @Test
    public void testClassNames(){
        System.out.println("<============aopConfig类名称：" + aopConfig.getClass().getName());
        System.out.println("<============context类名称：" + context.getClass().getName());
        System.out.println("<============lifecycleProcessor类名称：" + lifecycleProcessor.getClass().getName());
        System.out.println("<============environment类名称：" + environment.getClass().getName());
        System.out.println("<============servletContextInitializer类名称：" + servletContextInitializer.getClass().getName());
        System.out.println("<============proxyConfig类名称：" + proxyConfig.getClass().getName());
        System.out.println("<============proxyCreator类名称：" + proxyCreator.getClass().getName());
//        System.out.println("<============proxyFactory类名称：" + proxyFactory.getClass().getName());

    }
    @Test
    public void testAopProgramatically2(){
        System.out.println("<============jdk service ===================>");
        NotVeryUsefulService serviceObj = new NotVeryUsefulService();
        NotVeryUsefulAspect programaticAspect = new NotVeryUsefulAspect();
        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(serviceObj);

        proxyFactory.addAspect(programaticAspect);
        NotVeryUsefulInterface proxy = proxyFactory.getProxy();
        System.out.println(proxy.getClass().getName());
        proxy.thisDemo();
        System.out.println("<============force cglib service===================>");

        proxyFactory.setProxyTargetClass(true);//是否需要使用CGLIB代理
         proxy = proxyFactory.getProxy();
        System.out.println(proxy.getClass().getName());
        proxy.thisDemo();
    }
}