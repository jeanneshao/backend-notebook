package com.example.jdbctemplatedemo.mapper;

import com.example.jdbctemplatedemo.entity.DemoFullExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeanne 2023/7/8
 **/
@Slf4j
@SpringBootTest()
@ActiveProfiles({"dev"})
class DemoFullExampleMappingQueryTest {
    @Resource
    DemoFullExampleMappingQuery demoFullExampleMappingQuery;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mapRow() {
        DemoFullExample demoFullExample = demoFullExampleMappingQuery.findObject(436l, "%a----%");
        log.info("maprow result: {}",demoFullExample);
    }
    @Test
    void mapRows() {
        List<DemoFullExample> demoFullExamples = demoFullExampleMappingQuery.execute(null, "%a%");
        log.info("maprow result: {}",demoFullExamples.size());
    }
}