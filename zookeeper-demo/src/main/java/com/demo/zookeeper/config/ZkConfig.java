package com.demo.zookeeper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/9/21
 **/
@Data
@Component
@ConfigurationProperties(prefix = "curator")
public class ZkConfig {
    // 重试次数
    private int retryCount;

    // 重试的间隔时间（单位：毫秒）
    private int sleepBetweenRetries;

    // zk连接地址（多个zk的时候，用逗号分割）
    private String connect;

    // 会话超时时间（单位：毫秒）
    private int sessionTimeout;

    // 连接超时时间（单位：毫秒）
    private int connectionTimeout;
}
