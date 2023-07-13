package com.example.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest()
@TestPropertySource(locations = "classpath:application-dev.yml")
class WebApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void contextLoads2() {
    }

}
