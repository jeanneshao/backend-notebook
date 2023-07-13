package com.example.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Jeanne 2023/7/11
 **/
@Slf4j
public class WebServerInitializedEventListener implements ApplicationListener<WebServerInitializedEvent>  {
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        log.info("4.1<------------------{}------------------>", event.getClass().getSimpleName());
    }

}
