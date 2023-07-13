package com.example.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Jeanne 2023/7/11
 **/
@Slf4j
public class ApplicationStartingDemoListener implements ApplicationListener<ApplicationStartingEvent>  {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("1<------------------{}------------------>", event.getClass().getSimpleName());
    }

}
