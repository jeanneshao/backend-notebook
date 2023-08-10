package com.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
@Slf4j
class RedisDemoApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    ValueOperations valueOperations;


    @Test
    void contextLoads() {
        log.info("contextLoads");
    }

    @Test
    void redisWriteString() {
        valueOperations = stringRedisTemplate.opsForValue();
//        // set study:1 study-1
//        valueOperations.set("study:1", "study-1");
//        log.info((String) valueOperations.get("study:1")); //study-1

//        // set study:1 study-1 nx
//        valueOperations.setIfAbsent("study:1", "study-2");
//        log.info((String) valueOperations.get("study:1")); //study-1

//        // set study:1 study-1 xx
//        valueOperations.setIfPresent("study:1", "study-3");
//        log.info((String) valueOperations.get("study:1")); //study-3

//        valueOperations.setIfPresent("study:2", "study-3");
//        log.info((String) valueOperations.get("study:2")); //null

//        valueOperations.set("study-incre","0");
//        log.info( (String) valueOperations.get("study-incre")); //0
//        // incr study-incre
//        valueOperations.increment("study-incre");
//        log.info( (String) valueOperations.get("study-incre")); //1
//        //        // incrby study-incre 2
//        valueOperations.increment("study-incre",2l);
//        log.info( (String) valueOperations.get("study-incre")); //3
//        //        incrbyfloat total-crashes 2.3
//        valueOperations.increment("study-incre",2.3);
//        log.info( (String) valueOperations.get("study-incre")); //5.3

//        valueOperations.set("study-decr", "0");
//        // decr total-crashes
//        valueOperations.decrement("study-decr");
//        log.info((String) valueOperations.get("study-decr")); //4.3
//        // decrby total-crashes 2
//        valueOperations.decrement("study-decr", 2);
//        log.info((String) valueOperations.get("study-decr")); //2.3


    }

}
