package com.example.jdbctemplatedemo.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeanne 2023/7/6
 **/
@Slf4j
@SpringBootTest
class DemoDaoTest {
    @Autowired
    DemoDao demoDao;

    @Test
    void query() {
        int rowCount = demoDao.jdbcTemplate.queryForObject("select count(*) from asset",
                Integer.class);
        log.info("asset has {} records", rowCount);
    }
}