package com.demo.security.config;

import com.demo.security.evaluators.DemoVoPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author Jeanne 2023/7/18
 **/
/*@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Configuration*/
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    @Bean
    public PermissionEvaluator permissionEvaluator() {
        return new DemoVoPermissionEvaluator();
    }

    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new DemoVoPermissionEvaluator());
        return expressionHandler;
//        return super.createExpressionHandler();
    }
}
