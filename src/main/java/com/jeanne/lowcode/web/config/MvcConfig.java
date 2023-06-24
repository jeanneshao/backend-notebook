package com.jeanne.lowcode.web.config;

import com.jeanne.lowcode.web.databinder.DataBinderVoFormatter;
import com.jeanne.lowcode.web.interceptor.CallableProcessingDemoInterceptor;
import com.jeanne.lowcode.web.interceptor.DeferredResultDemoInterceptor;
import com.jeanne.lowcode.web.validations.DemoGlobalValidator;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.HttpMethod;
import org.springframework.validation.Validator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.Arrays;

/**
 * @author Jeanne 2023/6/21
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //xml: <mvc:annotation-driven enable-matrix-variables="true"/>
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CallableProcessingDemoInterceptor());
        registry.addInterceptor(new DeferredResultDemoInterceptor());

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.registerCallableInterceptors(new CallableProcessingDemoInterceptor());
        configurer.registerDeferredResultInterceptors(new DeferredResultDemoInterceptor());
    }


//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/cors2/allow/**")
//                .allowedOrigins("http://localhost:63343")
//                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name())
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(10);
//    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:63343"));
        configuration.setAllowedMethods(Arrays.asList(HttpMethod.GET.name(), HttpMethod.POST.name()));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/cors2/allow/**", configuration);
        return source;
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DataBinderVoFormatter());
    }
    @Override
    public Validator getValidator() {
        return  new DemoGlobalValidator();
    }
}
