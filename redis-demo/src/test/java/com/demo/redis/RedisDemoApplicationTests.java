package com.demo.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisDemoApplicationTests {

    @Resource
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

}
