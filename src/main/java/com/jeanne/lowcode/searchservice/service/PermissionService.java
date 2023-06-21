package com.jeanne.lowcode.searchservice.service;

import com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

import java.lang.reflect.Member;

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
