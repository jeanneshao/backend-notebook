package com.demo.security.config;

import com.demo.security.filter.Demo2Filter;
import com.demo.security.filter.DemoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @author Jeanne 2023/7/17
 **/
@Configuration
public class DelegatingFilterProxyConfig {
    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> demo2FilterProxy() {
        FilterRegistrationBean<DelegatingFilterProxy> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new DelegatingFilterProxy("demo2Filter"));
        registrationBean.addUrlPatterns("/skipAuth/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); // Set the desired order here

        return registrationBean;
    }

    @Bean
    public Demo2Filter demo2Filter() {
        return new Demo2Filter();
    }
}
