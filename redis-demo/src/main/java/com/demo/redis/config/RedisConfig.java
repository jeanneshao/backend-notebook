package com.demo.redis.config;

import com.demo.redis.pubsub.RedisSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author Jeanne 2023/8/14
 **/
@Configuration
public class RedisConfig {
    @Autowired
    RedisProperties redisProperties;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
                                                                       RedisSubscriber redisSubscriber) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(redisSubscriber, new ChannelTopic("redis-channel-demo")); // Add your desired channel/topic
        return container;
    }

    //    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        // Configure the connection factory for the first Redis database
//        LettuceConnectionFactory connectionFactory1 = new LettuceConnectionFactory();
//        connectionFactory1.setDatabase(1);
//        // Configure other connection factory properties as needed
//        return connectionFactory1;
//    }
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // Configure RedisTemplate properties as needed
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate redisTemplate2(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisProperties.getHost());
        redisConfig.setPassword(redisProperties.getPassword());
        redisConfig.setDatabase(1);
        // Configure the connection factory for the second Redis database
        LettuceConnectionFactory connectionFactory2 = new LettuceConnectionFactory(redisConfig);
        connectionFactory2.afterPropertiesSet(); // Ensure proper initialization

        // Configure other connection factory properties as needed
        redisTemplate.setConnectionFactory(connectionFactory2);
        // Configure RedisTemplate properties as needed
        return redisTemplate;
    }

}
