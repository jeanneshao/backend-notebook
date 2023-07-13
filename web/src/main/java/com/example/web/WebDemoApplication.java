package com.example.web;

import com.example.web.listeners.DemoListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Jeanne 2023/6/17
 **/
@SpringBootApplication
public class WebDemoApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebDemoApplication.class);
        application.addListeners(new DemoListener());
        application.setEnvironmentPrefix("demo");
        ConfigurableApplicationContext applicationContext =  application.run(args);

        new SpringApplicationBuilder()
                .sources(WebDemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
//                .listeners(new DemoListener())
                .run(args);
    }
}
