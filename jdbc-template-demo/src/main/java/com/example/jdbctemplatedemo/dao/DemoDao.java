package com.example.jdbctemplatedemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Jeanne 2023/7/6
 **/
@Repository
public class DemoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void query(){


    }

}
