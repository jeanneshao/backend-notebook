package com.jeanne.lowcode.aopdemo;

import com.jeanne.lowcode.aopdemo.aspect.NotVeryUsefulAspect;
import com.jeanne.lowcode.aopdemo.aspect.aspectj.Account;
import com.jeanne.lowcode.aopdemo.aspect.introduction.DemoInterface;
import com.jeanne.lowcode.aopdemo.aspect.programatically.ProgramaticAspect;
import com.jeanne.lowcode.aopdemo.service.NotVeryUsefulInterface;
import com.jeanne.lowcode.aopdemo.service.NotVeryUsefulService;
import com.jeanne.lowcode.aopdemo.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;

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
    public void testInternal() {
        permissionService.internalCall();
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

    static {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\git\\aspectj-demo\\target");
    }

    @Test
    public void testAopProgramatically() {


        PermissionService serviceObj = new PermissionService();
        ProgramaticAspect programaticAspect = new ProgramaticAspect();
        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(serviceObj);

//        proxyFactory.addAspect(ProgramaticAspect.class);
        proxyFactory.addAspect(programaticAspect);

        proxyFactory.setProxyTargetClass(true);//是否需要使用CGLIB代理

        PermissionService proxy = proxyFactory.getProxy();
        Class<? extends PermissionService> aClass = proxy.getClass();


        Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(aClass);

        proxy.dataAccessOperation(22, "abd");

    }

    @Test
    public void testAopProgramaticallyJDK() {

        NotVeryUsefulService serviceObj = new NotVeryUsefulService();
        NotVeryUsefulAspect programaticAspect = new NotVeryUsefulAspect();
        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(serviceObj);

        proxyFactory.addAspect(programaticAspect);


        NotVeryUsefulInterface proxy = proxyFactory.getProxy();


        proxy.transfer();

    }


    @Test
    public void testAspectJ() {
        Account account = context.getBean(Account.class);
        account.callService();

//        account = new Account();
//        account.callService();
    }


}
