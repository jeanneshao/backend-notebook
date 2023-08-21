package com.demo.redis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/8/14
 **/
@Slf4j
@Component
public class RedisSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("RedisSubscriber on message ===>{}", message);
    }
}
