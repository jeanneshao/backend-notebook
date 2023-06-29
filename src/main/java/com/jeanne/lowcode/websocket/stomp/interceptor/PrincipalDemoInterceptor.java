package com.jeanne.lowcode.websocket.stomp.interceptor;

import com.jeanne.lowcode.websocket.stomp.dto.StimulatedPrincipal;
import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.ExecutorChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jeanne 2023/6/27
 **/
public class PrincipalDemoInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor =
                MessageHeaderAccessor.getAccessor(message,
                        StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
            if (raw instanceof Map) {
                Object name = ((Map) raw).get("authentication");
                if (name instanceof List) {
                    // 设置当前访问器的认证用户
                    accessor.setUser(new StimulatedPrincipal(((List) name).get(0).toString()));
                }
            }
        }
        return message;
    }


}
