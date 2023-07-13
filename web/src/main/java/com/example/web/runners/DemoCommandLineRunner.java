package com.example.web.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/12
 **/
@Component
@Order(1)
@Slf4j
public class DemoCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("DemoCommandLineRunner::1");
    }
}
