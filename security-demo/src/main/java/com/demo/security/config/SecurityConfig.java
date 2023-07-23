package com.demo.security.config;

import com.demo.security.evaluators.DemoVoPermissionEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * @author Jeanne 2023/7/18
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").access("hasPermission(#contact, 'admin')")
//                .anyRequest().authenticated()
//                .and().formLogin();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }


}
