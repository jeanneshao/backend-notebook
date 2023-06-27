package com.jeanne.lowcode.websocket.sockjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Jeanne 2023/6/17
 **/
@SpringBootApplication
public class WebSocketSockjsApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebSocketSockjsApplication.class, args);

    }
}
