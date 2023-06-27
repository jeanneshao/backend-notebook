package com.jeanne.lowcode.websocket.stomp.config;

import com.jeanne.lowcode.websocket.stomp.interceptor.HandshakeDemoIntercpetor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * websocket配置类
 *
 * @author zhangxy13@aisainfo-int.com
 * @date 2020-07-21
 */
@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class StompConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {


        // 添加访问端点
        registry.addEndpoint("/websocket3")
                .addInterceptors(new HandshakeDemoIntercpetor())
//                .setAllowedOrigins("http://localhost:63343")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic","/queue");
    }


}
