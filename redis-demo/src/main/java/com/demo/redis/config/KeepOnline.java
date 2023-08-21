package com.demo.redis.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/8/14
 **/
@Component
public class KeepOnline {
    @Scheduled(fixedDelay = 5000) // Runs every 1 second
    public void doSomething() {
        // Perform your desired logic here
        System.out.println("keep online");
    }
}
