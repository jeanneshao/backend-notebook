package com.example.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Jeanne 2023/7/11
 **/
@Slf4j
public class DemoFactoriesListener implements ApplicationListener<SpringApplicationEvent>  {
    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        log.info("<------------------DemoFactoriesListener::{}", event.getClass().getSimpleName());

    }



}
