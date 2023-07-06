package com.example.transactionmybatisdemo.service;

import com.example.transactionmybatisdemo.listeners.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeanne 2023/7/6
 **/
@Service
public class EventService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
    public void sendEvent(DemoEvent demoEvent){
        publisher.publishEvent(demoEvent);
    }

    public DemoEvent createEvent(String title, String content){
        return new DemoEvent(this, title,content);
    }
    public void emit(String title, String content){
        sendEvent(createEvent(title, content));
    }
}
