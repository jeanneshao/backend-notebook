package com.demo.zookeeper.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author: muse
 **/
@Configuration
public class CuratorConfig {

    @Resource
    private ZkConfig zkConfig;

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new RetryNTimes(zkConfig.getRetryCount(), zkConfig.getSleepBetweenRetries());
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
                zkConfig.getConnect(),
                zkConfig.getSessionTimeout(),
                zkConfig.getConnectionTimeout(), retryPolicy);
        return curatorFramework;
    }
}

