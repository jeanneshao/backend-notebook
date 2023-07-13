package com.example.web.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/12
 **/
@Component
@Slf4j
public class DemoApplicationRunner2 implements ApplicationRunner, Ordered {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("DemoApplicationRunner::2");
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
