package com.demo.redis.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/8/14
 **/
@Service
public class RedisPublisher {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void publishMessage(String channel, String message) {
        stringRedisTemplate.convertAndSend(channel, message);
    }
}
