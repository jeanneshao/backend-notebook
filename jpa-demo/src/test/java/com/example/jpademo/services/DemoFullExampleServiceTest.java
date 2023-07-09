package com.example.jpademo.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

/**
 * @author Jeanne 2023/7/9
 **/
@SpringBootTest
@Slf4j
@ActiveProfiles({"dev"})
class DemoFullExampleServiceTest {
    @Resource
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
    @Resource
    EntityManagerFactory entityManagerFactory;

    @Test
    void save() {
        log.info("save");
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getById() {
    }

    @Test
    void query() {
    }
}