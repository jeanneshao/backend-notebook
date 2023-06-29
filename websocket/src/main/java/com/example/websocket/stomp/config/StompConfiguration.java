package com.example.websocket.stomp.config;

import com.example.websocket.stomp.interceptor.ExecutorChannelDemoInterceptor;
import com.example.websocket.stomp.interceptor.HandshakeDemoIntercpetor;
import com.example.websocket.stomp.interceptor.PrincipalDemoInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.TaskScheduler;
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
@Order(Ordered.HIGHEST_PRECEDENCE + 99)//优先级一定要比Spring-Security的高，才会用它来鉴权
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


    private TaskScheduler messageBrokerTaskScheduler;
    @Autowired
    public void setMessageBrokerTaskScheduler(@Lazy TaskScheduler taskScheduler) {
        this.messageBrokerTaskScheduler = taskScheduler;
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic","/queue")
                .setHeartbeatValue(new long[] {10000, 20000})
                .setTaskScheduler(this.messageBrokerTaskScheduler);
//        registry.setUserDestinationPrefix("/user");

    }

    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ExecutorChannelDemoInterceptor());
        registration.interceptors(new PrincipalDemoInterceptor());
    }
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ExecutorChannelDemoInterceptor());
    }

//    @Bean
    public PrincipalDemoInterceptor createUserInterceptor() {
        return new PrincipalDemoInterceptor();
    }

}
