package com.jeanne.lowcode.websocket.stomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Jeanne 2023/6/17
 **/
@SpringBootApplication
public class WebSocketDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebSocketDemoApplication.class, args);

    }
}
