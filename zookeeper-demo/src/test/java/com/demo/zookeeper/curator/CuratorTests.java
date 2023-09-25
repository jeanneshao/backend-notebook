package com.demo.zookeeper.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @author Jeanne 2023/9/21
 **/
@Slf4j
@SpringBootTest
public class CuratorTests {
    @Resource
    private CuratorFramework curatorFramework;

    static String BASE_PATH = "/CURATOR_TEST";
    static String TTL_DEMO = "/CURATOR_TEST/TTL_DEMO";
    String data = "LALALA" + System.currentTimeMillis();

    @Test
    public void testComplex(){
        try {
            curatorFramework.create()
                    .orSetData()
//                    .withTtl(5000l)
                    .creatingParentsIfNeeded()
                    .forPath(BASE_PATH, data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("<======Catch Error======>", e);
        }

    }

    @Test
    void testTtl(){
        try {
            curatorFramework.blockUntilConnected();
            curatorFramework.create()
                    .withTtl(5000l)
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT_WITH_TTL)
                    .forPath(TTL_DEMO,data.getBytes(StandardCharsets.UTF_8));
        } catch (InterruptedException e) {
            log.error("<======Catch Error======>", e);
        } catch (Exception exception) {
            log.error("<======Catch Error======>", exception);
        }


    }
}
