package com.jeanne.lowcode.websocket.stomp.interceptor;

import com.jeanne.lowcode.websocket.stomp.dto.StimulatedPrincipal;
import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ExecutorChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.util.Map;
import java.util.Optional;

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
