package com.example.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Jeanne 2023/7/11
 **/
@Slf4j
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>  {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("7<------------------{}------------------>", event.getClass().getSimpleName());
    }

}
