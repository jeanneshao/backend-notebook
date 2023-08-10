package com.example.mysql.mapper;

import com.example.mysql.TestBase;
import com.example.mysql.domain.S1;
import com.example.mysql.domain.S2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.UUID;

/**
 * @author Jeanne 2023/8/8
 **/
@SpringBootTest
@Slf4j
class S2MapperTest extends TestBase {

    @Autowired
    S2Mapper s2Mapper;
    @Autowired
    S1Mapper s1Mapper;

    Random random = new Random();

    @Test
    public void inflateTable() {
        for (int i = 0; i < 10000; i++) {
            S2 randonS2 = getRandonS2();
            s2Mapper.insert(randonS2);
            S1 randonS1 = getRandonS1(randonS2);
            s1Mapper.insert(randonS1);
        }
    }

    public S2 getRandonS2() {
        S2 s2 = S2.builder().key1(UUID.randomUUID().toString())
                .key2(random.nextInt())
                .key3(UUID.randomUUID().toString())
                .commonField(UUID.randomUUID().toString())
                .keyPart1(UUID.randomUUID().toString())
                .keyPart2(UUID.randomUUID().toString())
                .keyPart3(UUID.randomUUID().toString()).build();
        return s2;
    }
    public S1 getRandonS1(S2 s2) {
        S1 s1 = S1.builder().key1(s2.getKey1())
                .key2(s2.getKey2())
                .key3(s2.getKey3())
                .commonField(s2.getCommonField())
                .keyPart1(s2.getKeyPart1())
                .keyPart2(s2.getKeyPart2())
                .keyPart3(s2.getKeyPart3()).build();
        return s1;
    }
    public S1 getRandonS1() {
        S1 s1 = S1.builder().key1(UUID.randomUUID().toString())
                .key2(random.nextInt())
                .key3(UUID.randomUUID().toString())
                .commonField(UUID.randomUUID().toString())
                .keyPart1(UUID.randomUUID().toString())
                .keyPart2(UUID.randomUUID().toString())
                .keyPart3(UUID.randomUUID().toString()).build();
        return s1;
    }
}