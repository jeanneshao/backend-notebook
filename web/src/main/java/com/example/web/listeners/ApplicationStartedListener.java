package com.example.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Jeanne 2023/7/11
 **/
@Slf4j
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent>  {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("5<------------------{}------------------>", event.getClass().getSimpleName());
    }

}
