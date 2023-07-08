package com.example.jdbctemplatedemo.dao;

import com.example.jdbctemplatedemo.entity.DemoFullExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.jdbctemplatedemo.dao.JdbcTemplateTest.getDemoFullExamples;

/**
 * @author Jeanne 2023/7/8
 **/
@Slf4j
@SpringBootTest()
@ActiveProfiles({"dev"})
public class SimpleJdbcInsertTest {

    @Resource
    DataSource dataSource;


    @Test
    public void add() {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(dataSource).withTableName("full_example");
        int count = (int) (Math.random() * 100);
        List<DemoFullExample> data = getDemoFullExamples(count);

        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("name", data.get(0).getName());
        insertActor.execute(parameters);
    }

    @Test
    public void add2() {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("full_example")
                .usingGeneratedKeyColumns("id");
        int count = (int) (Math.random() * 100);
        List<DemoFullExample> data = getDemoFullExamples(count);

        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("name", data.get(0).getName());
        Number id = insertActor.executeAndReturnKey(parameters);
        log.info("obtained id {}", id);
    }

    @Test
    public void add3() {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("full_example")
                .usingGeneratedKeyColumns("id");
        int count = (int) (Math.random() * 100);
        List<DemoFullExample> data = getDemoFullExamples(count);

        SqlParameterSource parameters = new BeanPropertySqlParameterSource(data.get(0));
        Number id = insertActor.executeAndReturnKey(parameters);
        log.info("obtained id {}", id);
    }

    @Test
    public void add4() {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("full_example")
                .usingGeneratedKeyColumns("id");
        int count = (int) (Math.random() * 100);
        List<DemoFullExample> data = getDemoFullExamples(count);
        DemoFullExample actor = data.get(0);

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", actor.getName())
                .addValue("date_time_example", actor.getDateTimeExample())
                .addValue("number_example", actor.getNumberExample());
        Number id = insertActor.executeAndReturnKey(parameters);
        log.info("obtained id {}", id);
    }

    /**
     * use low_code_demo;
     * drop procedure if exists GetFullExampleByID;
     * DELIMITER //
     * CREATE PROCEDURE GetFullExampleByID(IN in_id INT)
     * BEGIN
     * SELECT * FROM low_code_demo.full_example WHERE ID = in_id;
     * END //
     * DELIMITER ;
     * <p>
     * CALL GetFullExampleByID(1);
     */
    @Test
    public void callProcedure() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("GetFullExampleByID");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", 436l);
        Map out = simpleJdbcCall.execute(in);
        DemoFullExample actor = new DemoFullExample();
        actor.setId(436l);
        actor.setName((String) (
                (Map) ((List) out.get("#result-set-1")).get(0)).get("name")
        );
        log.info("result {}", actor);
    }

    @Test
    public void callProcedure2() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("GetFullExampleByID2");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", 436l);
        Map out = simpleJdbcCall.execute(in);
        DemoFullExample actor = new DemoFullExample();
        actor.setId(436l);
        actor.setNumberExample((Long) out.get("out_number_example"));
        actor.setName((String) out.get("out_name"));
        actor.setDateTimeExample((LocalDateTime) out.get("out_date"));
        log.info("result {}", actor);
    }

    @Test
    public void callProcedure3() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("GetFullExampleByID2")
                .withoutProcedureColumnMetaDataAccess()
                .useInParameterNames("in_id")
                .declareParameters(
                        new SqlParameter("in_id", Types.NUMERIC),
                        new SqlOutParameter("out_number_example", Types.BIGINT),
                        new SqlOutParameter("out_name", Types.VARCHAR),
                        new SqlOutParameter("out_date", Types.DATE)
                );

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", 436l);
        Map out = simpleJdbcCall.execute(in);
        DemoFullExample actor = new DemoFullExample();
        actor.setId(436l);
        actor.setNumberExample((Long) out.get("out_number_example"));
        actor.setName((String) out.get("out_name"));
//        actor.setDateTimeExample((LocalDateTime) out.get("out_date"));
        log.info("result {}", actor);
    }

    @Test
    public void callProcedure4() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("GetFullExampleByID4")
                .returningResultSet("resultSet",
                         BeanPropertyRowMapper.newInstance(DemoFullExample.class));

        Map out = simpleJdbcCall.execute(new HashMap<>());
        List results = (List) out.get("resultSet");

        log.info("result {}", results.size());
    }

}
