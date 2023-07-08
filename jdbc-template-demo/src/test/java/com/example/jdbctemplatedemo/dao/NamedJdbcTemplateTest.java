package com.example.jdbctemplatedemo.dao;

import com.example.jdbctemplatedemo.entity.DemoFullExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.*;

import static com.example.jdbctemplatedemo.dao.JdbcTemplateTest.getDemoFullExamples;

/**
 * @author Jeanne 2023/7/6
 **/
@Slf4j
@SpringBootTest()
@ActiveProfiles({"dev"})
class NamedJdbcTemplateTest {

    @Resource
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    void q1() {
        String sql = "select count(*) from full_example where name like :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource("name",
                "%a%");
        Integer rowCount = namedParameterJdbcTemplate.queryForObject(sql, namedParameters,
                Integer.class);
        log.info("<-------------asset has {} records------------->", rowCount);
    }

    @Test
    void q2() {
        String sql = "select count(*) from full_example where name like :name";
        Map<String, String> namedParameters = Collections.singletonMap("name", "%a%");
        Integer rowCount = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
        log.info("<-------------asset has {} records------------->", rowCount);
    }

    @Test
    void q3() {
        DemoFullExample demoFullExample = new DemoFullExample();
        demoFullExample.setName("Watling").setTextAreaExample("sss");

        // notice how the named parameters match the properties of the above 'Actor' class
        String sql = " select count(*) from full_example where name1=:name and text_area_example =:textAreaExample";

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(demoFullExample);
        Integer rowCount = this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
        log.info("<-------------asset has {} records------------->", rowCount);

    }
    @Test
    void q4(){
        String sql = "SELECT name FROM full_example WHERE id IN (:ids)";
        Map<String, List<Long>> paramMap = new HashMap<>();
        paramMap.put("ids", Arrays.asList(1l, 100l, 300l));
        List<String> names = namedParameterJdbcTemplate.query(sql, paramMap, (rs, rowNum) -> rs.getString("name"));
        log.info("where in result: {}",names);
    }

    @Test
    public void testBatch2() {
        int count = (int)(Math.random()*100);
        List<DemoFullExample> data = getDemoFullExamples(count);

        String sql  = "insert into full_example (name,date_time_example,number_example ) values (:name, :dateTimeExample,:numberExample)";

        namedParameterJdbcTemplate.batchUpdate(
                sql,
                SqlParameterSourceUtils.createBatch(data));
        System.out.println("Batch update completed successfully.");
    }

}