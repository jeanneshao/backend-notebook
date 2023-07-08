package com.example.jdbctemplatedemo.entity;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jeanne 2023/7/8
 **/
@Slf4j
@SpringBootTest()
@ActiveProfiles({"dev"})
class DemoLobDemoTest {
    @Resource
    JdbcTemplate jdbcTemplate;
    //    @Resource
    DefaultLobHandler defaultLobHandler = new DefaultLobHandler();

    @Test
    @SneakyThrows
    public void testInsertBlob() {
//        final File blobIn = ResourceUtils.getFile("classpath:images/screenshot.png") ;//new File("spring2004.jpg");
        final File blobIn = ResourceUtils.getFile("classpath:images/screenshot.jpeg");//new File("spring2004.jpg");
        final InputStream blobIs = new FileInputStream(blobIn);
//        final File blobIn2 = ResourceUtils.getFile("classpath:images/0.gif") ;//new File("spring2004.jpg");
        final File blobIn2 = ResourceUtils.getFile("classpath:images/0.gifsss");//new File("spring2004.jpg");
        final InputStream blobIs2 = new FileInputStream(blobIn2);
        final File clobIn = ResourceUtils.getFile("classpath:images/large.txt");
        String content = new String(Files.readAllBytes(clobIn.toPath()));
//        final InputStream clobIs = new FileInputStream(clobIn);
//        final InputStreamReader clobReader = new InputStreamReader(clobIs);
        jdbcTemplate.execute(
                "INSERT INTO low_code_demo.lob_demo ( blob_demo, long_blob_demo,long_text_demo) VALUES (?, ?, ?)",
                new AbstractLobCreatingPreparedStatementCallback(defaultLobHandler) {

                    protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws
                            SQLException {
                        lobCreator.setBlobAsBinaryStream(ps, 1, blobIs2, (int) blobIn2.length());
                        lobCreator.setBlobAsBinaryStream(ps, 2, blobIs, (int) blobIn.length());
                        ps.setString(3, content);

                    }
                }
        );
        blobIs.close();
//        clobReader.close();
    }

    @Test
    void query() {
        List<Map<String, Object>> l = jdbcTemplate.query("select blob_demo, long_blob_demo,long_text_demo from low_code_demo.lob_demo",
                new RowMapper<Map<String, Object>>() {
                    public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
                        Map<String, Object> results = new HashMap<String, Object>();
                        String clobText = rs.getString("long_text_demo");
                        results.put("CLOB", clobText);
                        byte[] blobBytes = defaultLobHandler.getBlobAsBytes(rs, "blob_demo");
                        byte[] longBlobBytes = defaultLobHandler.getBlobAsBytes(rs, "long_blob_demo");
                        results.put("BLOB", blobBytes);
                        results.put("LongBlob", longBlobBytes);
                        return results;
                    }
                });
        log.info("results: {}",l );
    }


}