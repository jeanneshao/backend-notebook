package com.example.transactionmybatisdemo.listeners;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

/**
 * @author Jeanne 2023/7/6
 **/
public class DemoEvent extends ApplicationEvent {
    private final String title;
    private final String content;

    public DemoEvent(Object source, String title, String content) {
        super(source);
        this.title = title;
        this.content = content;
    }

}
