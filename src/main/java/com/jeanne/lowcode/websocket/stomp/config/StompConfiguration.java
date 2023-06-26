package com.jeanne.lowcode.websocket.stomp.config;

import com.jeanne.lowcode.websocket.stomp.interceptor.HandshakeDemoIntercpetor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/**
 * websocket配置类
 *
 * @author zhangxy13@aisainfo-int.com
 * @date 2020-07-21
 */
//@Configuration
//@EnableWebSocketMessageBroker
@Slf4j
public class StompConfiguration implements WebSocketMessageBrokerConfigurer{


    /**
     * Register STOMP endpoints mapping each to a specific URL and (optionally)
     * enabling and configuring SockJS fallback options.
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 添加访问端点
        registry.addEndpoint("/websocket3")
                .addInterceptors(new HandshakeDemoIntercpetor())
                // 许所有的域名跨域访问,仅仅这个不够，还需要在外层
                .setAllowedOrigins("http://localhost:63343")
                // SockJS协议
                .withSockJS();
    }

    /**
     * Configure message broker options.
     *
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 消息代理,这里配置自带的消息代理，也可以配置其它的消息代理
        // 一定要注意这里的参数，可以理解为开启通道,后面如果使用了"/XXX"来作为前缀，这里就要配置,同时这里的"/topic"是默认群发消息的前缀,前端在订阅群发地址的时候需要加上"/topic"
        registry.enableSimpleBroker("/t1","/t2");
        // 客户端向服务端发送消息需有的前缀,需要什么样的前缀在这里配置,但是不建议使用，这里跟下面首次订阅返回会有点冲突，如果不需要首次订阅返回消息，也可以加上消息前缀
         registry.setApplicationDestinationPrefixes("/t3");
        // 配置单发消息的前缀 /user，前端订阅一对一通信的地址需要加上"/user"前缀
//        registry.setUserDestinationPrefix("/user");

//        // 自定义调度器，用于控制心跳线程
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        // 线程池线程数，心跳连接开线程
//        taskScheduler.setPoolSize(1);
//        // 线程名前缀
//        taskScheduler.setThreadNamePrefix("websocket-heartbeat-thread-");
//        taskScheduler.setDaemon(true);
//        // 初始化
//        taskScheduler.initialize();
//
//        registry.enableSimpleBroker("/topic", "/queue")
//                .setHeartbeatValue(new long[]{25000, 25000})
//                .setTaskScheduler(taskScheduler);
//
//        // 所有以"/app" 开头的客户端消息或请求,都会路由到带有@MessageMapping 注解的方法中
//        registry.setApplicationDestinationPrefixes("/app");
//
//        // 用户名称前缀
//        registry.setUserDestinationPrefix("/user");

        /*
         * 1. 配置一对一消息前缀， 客户端接收一对一消息需要配置的前缀 如“'/user/'+userid + '/message'”，
         *    是客户端订阅一对一消息的地址 stompClient.subscribe js方法调用的地址
         * 2. 使用@SendToUser发送私信的规则不是这个参数设定，在框架内部是用UserDestinationMessageHandler处理，
         *    而不是 AnnotationMethodMessageHandler 或  SimpleBrokerMessageHandler
         *    or StompBrokerRelayMessageHandler，是在@SendToUser的URL前加“user+sessionId"组成
         */
//        registry.setUserDestinationPrefix("/user");

    }

    /**
     * 配置发送与接收的消息参数，可以指定消息字节大小，缓存大小，发送超时时间
     *
     * @param registration
     */
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        /*
         * 1. setMessageSizeLimit 设置消息缓存的字节数大小 字节
         * 2. setSendBufferSizeLimit 设置websocket会话时，缓存的大小 字节
         * 3. setSendTimeLimit 设置消息发送会话超时时间，毫秒
         */
        registration.setMessageSizeLimit(10240)
                .setSendBufferSizeLimit(10240)
                .setSendTimeLimit(10000);
    }

    /**
     * 设置输入消息通道的线程数
     *
     * @param registration
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        /*
         * 配置消息线程池
         * 1. corePoolSize 配置核心线程池，当线程数小于此配置时，不管线程中有无空闲的线程，都会产生新线程处理任务
         * 2. maxPoolSize 配置线程池最大数，当线程池数等于此配置时，不会产生新线程
         * 3. keepAliveSeconds 线程池维护线程所允许的空闲时间，单位秒
         */
        registration.taskExecutor().corePoolSize(10)
                .maxPoolSize(20)
                .keepAliveSeconds(60);
        // 添加stomp自定义拦截器, 使用enterprise id作为登录的用户名
//        registration.interceptors(channelInterceptor());
    }

    /**
     * 设置输出消息通道的线程数，默认线程为1，可以自己自定义线程数，最大线程数，线程存活时间
     *
     * @param registration
     */
    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.taskExecutor().corePoolSize(10)
                .maxPoolSize(20)
                .keepAliveSeconds(60);
    }

//    @Bean
//    public ChannelInterceptor channelInterceptor() {
//        return new InboundInterceptor();
//    }

}
