package com.jeanne.lowcode.searchservice;

import com.jeanne.lowcode.searchservice.service.NotVeryUsefulInterface;
import com.jeanne.lowcode.searchservice.service.NotVeryUsefulService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Proxy;


@SpringBootApplication(proxyBeanMethods = false)
public class SearchServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SearchServiceApplication.class, args);
        NotVeryUsefulInterface bean = applicationContext.getBean(NotVeryUsefulInterface.class);
        System.out.println("类名称："+bean.getClass().getName());
        System.out.println("bean instanceof IndexDao :"+(bean instanceof NotVeryUsefulInterface));
        System.out.println("bean instanceof IndexDaoImpl :"+(bean instanceof NotVeryUsefulService));
        System.out.println("bean instanceof Proxy :"+(bean instanceof Proxy));
        bean.thisDemo();
    }

}
