package com.demo.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
public class QuartzDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(QuartzDemoApplication.class, args);
        DataSource dataSource2 = (DataSource) applicationContext.getBean("separateDataSource");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
    }

}
