package com.jeanne.lowcode.searchservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * @author Jeanne 2023/5/30
 **/
@EnableSpringConfigured //相当于<context:spring-configured/>
@Configuration
//@EnableLoadTimeWeaving
public class AspectJConfig {
}
