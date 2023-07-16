package com.demo.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Jeanne 2023/7/16
 **/
@EnableScheduling
@Configuration
@Slf4j
public class ScheduleConfig {
    @Scheduled(fixedRate = 5000) // Run every 5 seconds
    public void demoScheduleTask() {
        // Method logic goes here
       log.info("Running scheduled method...");
    }
    @Scheduled(cron = "0/5 * * * * ? ") // Run every 5 seconds
    public void demoCronTask() {
        // Method logic goes here
        log.info("Running scheduled cron method...");
    }
}
