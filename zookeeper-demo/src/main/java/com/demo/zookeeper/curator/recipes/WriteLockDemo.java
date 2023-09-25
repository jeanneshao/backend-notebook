package com.demo.zookeeper.curator.recipes;

import com.demo.zookeeper.ZookeeperDemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Jeanne 2023/9/25
 **/
@SpringBootApplication
@Slf4j
public class WriteLockDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ZookeeperDemoApplication.class, args);
        CuratorFramework curatorFramework = (CuratorFramework) applicationContext.getBean("curatorFramework");
        InterProcessReadWriteLock rwlock = new InterProcessReadWriteLock(curatorFramework, "/write-lock");
        InterProcessMutex writeLock = rwlock.writeLock(); /** 获得写锁实例对象 */
        for (int i = 0; i< 3 ; i++) {
            new Thread(()-> {
                String threadName = Thread.currentThread().getName();
                try {
                    writeLock.acquire(); // 获取写锁
                    log.info("线程={}：等待获取Write锁成功！开始执行业务代码...", threadName);
                    Thread.sleep(1000);
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    try {
                        writeLock.release(); // 释放锁
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("<======Catch InterruptedException======>");
        }
    }

}
