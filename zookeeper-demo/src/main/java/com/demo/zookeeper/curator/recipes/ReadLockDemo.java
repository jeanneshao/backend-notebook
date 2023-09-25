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
public class ReadLockDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ZookeeperDemoApplication.class, args);
        CuratorFramework curatorFramework = (CuratorFramework) applicationContext.getBean("curatorFramework");
        InterProcessReadWriteLock rwlock = new InterProcessReadWriteLock(curatorFramework, "/read-lock");
        InterProcessMutex readLock = rwlock.readLock(); /** 获得读锁实例对象 */
        for (int i = 0; i< 10 ; i++) {
            new Thread(()-> {
                String threadName = Thread.currentThread().getName();
                try {
                    readLock.acquire(); // 获取读锁

                    log.info("线程={}：等待获取Read锁成功！开始执行业务代码...", threadName);
                    Thread.sleep(1000);
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    try {
                        readLock.release(); // 释放锁
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
