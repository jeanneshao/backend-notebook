package com.example.web.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/12
 **/
@Component
@Slf4j
public class DemoCommandLineRunner2 implements CommandLineRunner, Ordered {
    @Override
    public void run(String... args) throws Exception {
        log.info("DemoCommandLineRunner::2");
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
