package com.example.jdbctemplatedemo.mapper;

import com.example.jdbctemplatedemo.entity.DemoFullExample;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;

/**
 * entry resource
 */
@Data
@Accessors(chain = true)
@Component
public class DemoFullExampleMappingQuery extends MappingSqlQuery<DemoFullExample> {
    public DemoFullExampleMappingQuery(@Autowired DataSource dataSource) {
        super(dataSource, "select id, name,date_time_example,number_example from low_code_demo.full_example where id = ? or name like ?");
        declareParameter(new SqlParameter("id", Types.BIGINT));
        declareParameter(new SqlParameter("name", Types.VARCHAR));
        compile();
    }
    @Override
    protected DemoFullExample mapRow(ResultSet rs, int rowNumber) throws SQLException {
        DemoFullExample actor = new DemoFullExample();
        actor.setId(rs.getLong("id"));
        actor.setName(rs.getString("name"));
        actor.setDateTimeExample(rs.getObject("date_time_example", LocalDateTime.class));
        return actor;
    }

}
