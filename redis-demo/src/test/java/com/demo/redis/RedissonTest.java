package com.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author Jeanne 2023/8/20
 **/
@SpringBootTest
@Slf4j
public class RedissonTest {
    @Autowired
    RedisProperties redisProperties;

    @Test
    void testSingle() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(String.format("redis://%s:%s", redisProperties.getHost(), redisProperties.getPort()))
                .setPassword(redisProperties.getPassword())
                .setDatabase(0);
        //获取客户端
        RedissonClient redissonClient = Redisson.create(config);

        //获取所有的key
//        redissonClient.getKeys().getKeys().forEach(key -> System.out.println(key));
//
//        //字符串操作
//        RBucket<String> rBucket = redissonClient.getBucket("strKey");
//        // 设置value和key的有效期
//        rBucket.set("张三", 30, TimeUnit.SECONDS);
//        // 通过key获取value
//        System.out.println(redissonClient.getBucket("strKey").get());
//
//        DemoVo demoVo = DemoVo.builder().id(555l).name("ssssssj").build();
//        //对象操作
//        RBucket<DemoVo> rBucket2 = redissonClient.getBucket("DemoVo");
//// 设置value和key的有效期
//        rBucket2.set(demoVo);
//// 通过key获取value
//        System.out.println(redissonClient.getBucket("DemoVo").get());
//
//        //哈希操作
//        RMap<String, String> rMap = redissonClient.getMap("DemoMap");
//// 设置map中key-value
//        rMap.put("id", "123");
//        rMap.put("name", "赵四");
//        rMap.put("age", "50");
//// 通过key获取value
//        System.out.println(redissonClient.getMap("DemoMap").get("name"));
//
//        //字符串操作
//        RList<DemoVo> rList = redissonClient.getList("DemoVoList");
//
//        DemoVo demoVo2 = DemoVo.builder().id(2l).name(UUID.randomUUID().toString()).build();
//        DemoVo demoVo3 = DemoVo.builder().id(3l).name(UUID.randomUUID().toString()).build();
//
//        rList.addAll(Arrays.asList(demoVo,demoVo2,demoVo3));
//        System.out.println(redissonClient.getList("DemoVoList"));
//
//        RSet<DemoVo> rSet = redissonClient.getSet("DemoVoSet");
//        rSet.addAll(Arrays.asList(demoVo,demoVo2,demoVo3));
//
//        RSortedSet<DemoVo> sortSetkey = redissonClient.getSortedSet("DemoVoSorted");
//        sortSetkey.addAll(Arrays.asList(demoVo,demoVo2,demoVo3));


        RBloomFilter rBloomFilter = redissonClient.getBloomFilter("demo-bloom");
// 初始化预期插入的数据量为10000和期望误差率为0.01
        rBloomFilter.tryInit(10000, 0.01);
// 插入部分数据
        rBloomFilter.add("100");
        rBloomFilter.add("200");
        rBloomFilter.add("300");
//设置过期时间
//        rBloomFilter.expire(30, TimeUnit.SECONDS);
// 判断是否存在
        System.out.println(rBloomFilter.contains("300"));
        System.out.println(rBloomFilter.contains("200"));
        System.out.println(rBloomFilter.contains("999"));


        //关闭客户端
        redissonClient.shutdown();
    }

    @Test
    void testAutoIncrement() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(String.format("redis://%s:%s", redisProperties.getHost(), redisProperties.getPort()))
                .setPassword(redisProperties.getPassword())
                .setDatabase(0);
        //获取客户端
        RedissonClient redissonClient = Redisson.create(config);
        final String lockKey = "aaaa";
//通过redis的自增获取序号
        RAtomicLong atomicLong = redissonClient.getAtomicLong(lockKey);
//设置过期时间
//        atomicLong.expire(30, TimeUnit.SECONDS);
// 获取值
        System.out.println(atomicLong.incrementAndGet());
    }

    @Test
    //https://blog.csdn.net/asd051377305/article/details/108384490
    //https://zhuanlan.zhihu.com/p/596334390
    void testLock() {
        Config config = new Config();
        config.useSingleServer()
                .setConnectionMinimumIdleSize(1)
                .setAddress(String.format("redis://%s:%s", redisProperties.getHost(), redisProperties.getPort()))
                .setPassword(redisProperties.getPassword())
                .setDatabase(0);
        //获取客户端
        RedissonClient redissonClient = Redisson.create(config);
        //获取锁对象实例
        final String lockKey = "DistributionLock";
        RLock rLock = redissonClient.getLock(lockKey);

        try {
            //尝试5秒内获取锁，如果获取到了，最长60秒自动释放
            boolean res = rLock.tryLock(5L, 60L, TimeUnit.SECONDS);
            if (res) {
                //成功获得锁，在这里处理业务
                log.info("获取锁成功");
                Thread thread2 = new Thread(() -> testLock2());
                thread2.start();
                for (int i = 0; i < 30; i++) {
                    Thread.sleep(1000l);
                }
                log.info("准备释放锁");
            }
        } catch (Exception e) {
            log.error("获取锁失败，失败原因：" , e.getMessage());
        } finally {
            //无论如何, 最后都要解锁
            rLock.unlock();
            log.info("释放锁结束");
        }
    }
 @Test
    void testLock2() {
        Config config = new Config();
        config.useSingleServer()
                .setConnectionMinimumIdleSize(1)
                .setAddress(String.format("redis://%s:%s", redisProperties.getHost(), redisProperties.getPort()))
                .setPassword(redisProperties.getPassword())
                .setDatabase(0);
        //获取客户端
        RedissonClient redissonClient = Redisson.create(config);
        //获取锁对象实例
        final String lockKey = "DistributionLock";
        RLock rLock = redissonClient.getLock(lockKey);

        log.info("testLock2<===>开锁");

        try {
            while (rLock.isLocked()){
                log.info("testLock2<===>等待锁");
                Thread.sleep(1000l);
            }
            log.info("testLock2<===>锁放开了");

            //尝试5秒内获取锁，如果获取到了，最长60秒自动释放
            boolean res = rLock.tryLock(5L, 60L, TimeUnit.SECONDS);
            if (res) {
                //成功获得锁，在这里处理业务
                log.info("testLock2<===>获取锁成功");
            }
        } catch (Exception e) {
            log.error("testLock2<===>获取锁失败，失败原因：" , e.getMessage());
        } finally {
            //无论如何, 最后都要解锁
            rLock.unlock();
            log.info("testLock2<===>准备释放锁结束");
        }
    }

    @Test
    void testRRateLimiter() throws InterruptedException {
        Config config = new Config();
        config.useSingleServer()
                .setConnectionMinimumIdleSize(1)
                .setAddress(String.format("redis://%s:%s", redisProperties.getHost(), redisProperties.getPort()))
                .setPassword(redisProperties.getPassword())
                .setDatabase(0);
        //获取客户端
        RedissonClient redissonClient = Redisson.create(config);
        RRateLimiter demoRateLimiter = redissonClient.getRateLimiter("DemoRateLimiter");
        demoRateLimiter.setRate(RateType.OVERALL,1,5,RateIntervalUnit.SECONDS);
        for (int i = 0; i < 20; i++) {
//            new Thread(()-> {
                boolean allow = demoRateLimiter.tryAcquire();
                log.info("<======>allowed: {} ",allow);
//            }).start();

//            demoRateLimiter.acquire();
//            log.info("allowed2: {} for the {} th trial",allow, i);
            Thread.sleep(1000);
        }


    }

}
