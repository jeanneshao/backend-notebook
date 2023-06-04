package com.jeanne.lowcode.searchservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Jeanne 2023/5/29
 **/
@Configuration(proxyBeanMethods = false)
@EnableAspectJAutoProxy(proxyTargetClass = false)
//相当于xml中的<aop:aspectj-autoproxy/>
public class AopConfig {
}
