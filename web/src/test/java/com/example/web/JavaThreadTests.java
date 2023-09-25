package com.example.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest()
@TestPropertySource(locations = "classpath:application-dev.yml")
class JavaThreadTests {



    /*
    * ThreadLocal需要考虑的场景有：
    * 1. 创建
    * 2. 删除
    * 3. 更新
    * */
    @Test
    void testThreadLocal() {
        new Thread(()->{
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("test1");
            ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
            threadLocal.set("test1234");
            threadLocal2.set("test2");
            ThreadLocal<Long> threadLocal3 = new ThreadLocal<>();
            threadLocal = null;
            threadLocal3.set(999l);

        }).start();
    }


}
