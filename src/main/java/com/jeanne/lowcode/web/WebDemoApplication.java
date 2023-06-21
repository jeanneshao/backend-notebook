package com.jeanne.lowcode.web;

import com.jeanne.lowcode.ioc.packageinfo.PackageInfoComponent;
import com.jeanne.lowcode.ioc.packageinfo.PackageInfoConfiguration;
import com.jeanne.lowcode.searchservice.SearchServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;

/**
 * @author Jeanne 2023/6/17
 **/
@SpringBootApplication
public class WebDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebDemoApplication.class, args);

    }
}
