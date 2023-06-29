package com.example.websocket.stomp.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.ExecutorChannelInterceptor;

/**
 * @author Jeanne 2023/6/27
 **/
public class ExecutorChannelDemoInterceptor implements ExecutorChannelInterceptor {

    public  Message<?> beforeHandle(Message<?> message, MessageChannel channel, MessageHandler handler) {
       return message;
   }

    public void afterMessageHandled(Message<?> message, MessageChannel channel, MessageHandler handler,
                             @Nullable Exception ex) {
        System.out.println("ExecutorChannelDemoInterceptor afterMessageHandled");
    }


}
