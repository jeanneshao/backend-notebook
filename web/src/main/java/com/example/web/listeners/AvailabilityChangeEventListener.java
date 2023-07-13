package com.example.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Jeanne 2023/7/11
 **/
@Slf4j
public class AvailabilityChangeEventListener implements ApplicationListener<AvailabilityChangeEvent>  {
    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {
        log.info("6,8<------------------{}------------------>", event.getClass().getSimpleName());
    }

}
