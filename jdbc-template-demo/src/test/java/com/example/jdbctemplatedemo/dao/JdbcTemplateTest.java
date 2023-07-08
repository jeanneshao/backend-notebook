package com.example.jdbctemplatedemo.dao;

import com.example.jdbctemplatedemo.entity.DemoCustomer;
import com.example.jdbctemplatedemo.entity.DemoFullExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.InterruptibleBatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeanne 2023/7/6
 **/
@Slf4j
@SpringBootTest()
@ActiveProfiles({"dev"})
class JdbcTemplateTest {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    void query() {
        int rowCount = jdbcTemplate.queryForObject("select count(*) from asset",
                Integer.class);
        log.info("<-------------asset has {} records------------->", rowCount);
    }

    @Test
    void q2() {
        int countOftest = jdbcTemplate.queryForObject(
                "select count(*) from customer where title like ?", Integer.class, "%test%");
        log.info("<-------------there are {} test customers------------->", countOftest);
    }

    @Test
    void q3() {
        String title = this.jdbcTemplate.queryForObject(
                "select title from customer where search_text = ?",
                String.class, "name111 lastname11");
        log.info("<-------------title: {}------------->", title);

    }

    @Test
    void q4() {
        DemoCustomer actor = jdbcTemplate.queryForObject(
                "select * from customer where search_text = ?",
                (resultSet, rowNum) -> {
                    DemoCustomer newActor = new DemoCustomer();
                    newActor.setId(resultSet.getString("id"));
                    newActor.setTitle(resultSet.getString("title"));
                    return newActor;
                },
                "name111 lastname11");
        log.info("<-------------title: {}------------->", actor);
    }

    @Test
    void q5() {
        List<DemoCustomer> actors = jdbcTemplate.query(
                "select * from customer where search_text like ?",
                (resultSet, rowNum) -> {
                    DemoCustomer newActor = new DemoCustomer();
                    newActor.setId(resultSet.getString("id"));
                    newActor.setTitle(resultSet.getString("title"));
                    return newActor;
                },
                "%name%");
        log.info("<-------------customer: {}------------->", actors);
    }

    private final RowMapper<DemoCustomer> actorRowMapper = (resultSet, rowNum) -> {
        DemoCustomer actor = new DemoCustomer();
        actor.setId(resultSet.getString("id"));
        actor.setTitle(resultSet.getString("title"));
        return actor;
    };

    @Test
    public void findAllActors() {
        DemoCustomer actor = jdbcTemplate.queryForObject(
                "select * from customer where search_text = ?",
                actorRowMapper,
                "name111 lastname11");
        log.info("<-------------customer: {}------------->", actor);


        List<DemoCustomer> actors = this.jdbcTemplate.query(
                "select * from customer where search_text like ?",
                actorRowMapper,
                "%name%");

        log.info("<-------------customer count: {},customers{}------------->", actors.size());

    }


    @Test
    public void insert1() {
        this.jdbcTemplate.update(
                "insert into full_example (name,text_area_example ) values (?, ?)",
                "Watling", "sss");
    }

    @Test
    public void update1() {
        jdbcTemplate.update("UPDATE full_example t SET t.time_range_end = ? WHERE t.id = ?",
                "13:03:16", 1l);
    }

    @Test
    public void retrieveUpdate() {

        final String INSERT_SQL = "insert into full_example (name) values(?)";
        final String name = "Rob";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"
            });
            ps.setString(1, name);
            return ps;
        }, keyHolder);

        System.out.println(keyHolder);
    }

    @Test
    public void createTable() {
        this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
    }

    @Test
    public void droptable() {
        this.jdbcTemplate.execute("drop table if exists mytable");
    }

    @Test
    public void storedProcedure() {
        this.jdbcTemplate.update(
                "call base.GetFullExampleByID(?)",
                Long.valueOf(1));
    }

    @Test
    public void testBatch0() {
        this.jdbcTemplate.batchUpdate(
                "insert into full_example (name,date_time_example,number_example ) values (?, ?,?)",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws
                            SQLException {
                        DemoFullExample actor = new DemoFullExample();
                        actor.setName("JdbcTemplateTest::testBatch0").setDateTimeExample(LocalDateTime.now()).setNumberExample(20230708l);
                        ps.setString(1, actor.getName());
                        ps.setString(2, actor.getDateTimeExample().toString());
                        ps.setLong(3, actor.getNumberExample());
                    }

                    public int getBatchSize() {
                        return 10;
                    }
                });
    }

    @Test
    public void testBatch1() {
        int count = (int) (Math.random() * 100);
        List<DemoFullExample> data = getDemoFullExamples(count);

        String sql = "insert into full_example (name,date_time_example,number_example ) values (?, ?,?)";

        jdbcTemplate.batchUpdate(sql, new InterruptibleBatchPreparedStatementSetter() {
            @Override
            public boolean isBatchExhausted(int i) {
                log.info("isBatchExhausted:{}/{}", i, data.size());
                return i >= data.size() - 1;
            }

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, data.get(i).getName());
                preparedStatement.setString(2, data.get(i).getDateTimeExample().toString());
                preparedStatement.setLong(3, data.get(i).getNumberExample());
            }

            @Override
            public int getBatchSize() {
                log.info("getBatchSize:{}", data.size() + 100);
                return data.size() + 100;
            }
        });
        System.out.println("Batch update completed successfully.");
    }

    @Test
    public void testBatch3() {
        int count = (int) (Math.random() * 100);
        List<DemoFullExample> data = getDemoFullExamples(count);


        List<Object[]> batch = new ArrayList<Object[]>();
        for (DemoFullExample actor : data) {
            Object[] values = new Object[]{
//                    actor.getName(), actor.getDateTimeExample().toString(), actor.getNumberExample()};
                    actor.getName(), actor.getDateTimeExample().toString(), actor.getNumberExample(), null};
            batch.add(values);
        }
//        String sql = "insert into full_example (name,date_time_example,number_example ) values (?, ?,?)";
        String sql = "insert into full_example (name,date_time_example,number_example, text_area_example) values (?, ?,?,?)";
        this.jdbcTemplate.batchUpdate(
                sql,
                batch);
        System.out.println("Batch update completed successfully.");
    }

    @Test
    public void testBatchUpdateInBatch() {
        String sql = "insert into full_example (name,date_time_example,number_example) values (?, ?, ? )";
        int count = (int) (Math.random() * 100);
        List<DemoFullExample> data = getDemoFullExamples(count);
        int[][] updateCounts = jdbcTemplate.batchUpdate(
                sql,
                data,
                10,
                (PreparedStatement ps, DemoFullExample actor) -> {
                    ps.setString(1, actor.getName());
                    ps.setString(2, actor.getDateTimeExample().toString());
                    ps.setLong(3, actor.getNumberExample());

                });
        for (int i = 0; i < updateCounts.length; i++) {
            log.info("{}:{};",i, updateCounts[i]);

        }
    }

    public static List<DemoFullExample> getDemoFullExamples(int count) {
        List result = new ArrayList();
        for (int i = 0; i < count; i++) {
            DemoFullExample demoFullExample = new DemoFullExample();
            demoFullExample.setName("JdbcTemplateTest::testBatch0::" + i).setDateTimeExample(LocalDateTime.now()).setNumberExample(20230708l + i);
            result.add(demoFullExample);
        }

        return result;
    }
}