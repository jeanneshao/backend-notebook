package com.jeanne.lowcode.aopdemo.service;

import com.jeanne.lowcode.aopdemo.aspect.permission.PermissionAnnotation;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/5/29
 **/
@Service
@PermissionAnnotation
//@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = WebApplicationContext.SCOPE_SESSION,
//        proxyMode =ScopedProxyMode.INTERFACES)
//public class PermissionService implements ApplicationContextAware {
public class PermissionService  {

    @PermissionAnnotation
    public String dataAccessOperation() {
        System.out.println("hello aop");
        return "Hello";
    }
//    @Bean
//    @Scope("prototype")
//    public Object prototypeInstance(DependencyDescriptor injectionPoint) {
//        Member member = injectionPoint.getMember();
//        return new Object( );
//    }

    public String internalCall(){
       return  dataAccessOperation();
    }

    public String dataAccessOperation(int i) {
        System.out.println("hello aop111");
        return "Hello";
    }
   public String dataAccessOperation(int i,String name) {
        System.out.println("hello aop111");
        return "Hello";
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//
//    }
}
