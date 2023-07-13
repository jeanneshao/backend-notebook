package com.example.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Jeanne 2023/7/11
 **/
@Slf4j
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("4.2<------------------{}------------------>", event.getClass().getSimpleName());
    }

    @Override
    public void setApplicationContext(@Autowired ApplicationContext applicationContext) throws BeansException {

    }
}
