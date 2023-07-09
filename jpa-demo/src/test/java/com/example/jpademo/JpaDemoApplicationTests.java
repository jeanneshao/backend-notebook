package com.example.jpademo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
@ActiveProfiles({"dev"})
@Slf4j
class JpaDemoApplicationTests {
    @Resource
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
    @Resource
    EntityManagerFactory entityManagerFactory;
    @Resource
    EntityManagerFactoryBuilder factoryBuilder;
    @Resource
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    public void loadProductsByCategory() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryString = "SELECT e FROM DemoFullExample e WHERE e.id > :value";
            Query query = entityManager.createQuery(queryString);
             query.setParameter("value", 300l);
            List resultList = query.getResultList();
            log.info("get result list",resultList.size());

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    @Test
    public void batchDelete() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin(); String queryString = "delete FROM DemoFullExample e WHERE e.id < :value";
            Query query = entityManager.createQuery(queryString);
             query.setParameter("value", 100l);
            int count = query.executeUpdate();
            entityManager.getTransaction().commit();
            log.info("deleted {} records",count);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

}
