package com.jeanne.lowcode.searchservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeanne 2023/6/1
 **/
@Slf4j
@SpringBootTest
class NotVeryUsefulAspectTest {

    @BeforeEach
    void setUp() {
        log.info("<-------NotVeryUsefulAspectTest.setup------->");
    }

    @AfterEach
    void tearDown() {
        log.info("<-------NotVeryUsefulAspectTest.tearDown------->");

    }

    @Test
    void publicMethod() {
    }

    @Test
    void inTrading() {
    }

    @Test
    void tradingOperation() {
    }

    @Test
    void permissionCheckFirst() {
    }
}