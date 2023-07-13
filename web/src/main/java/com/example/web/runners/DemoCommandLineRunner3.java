package com.example.web.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/12
 **/
@Component
@Slf4j
public class DemoCommandLineRunner3 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("DemoCommandLineRunner::3");
    }

}
