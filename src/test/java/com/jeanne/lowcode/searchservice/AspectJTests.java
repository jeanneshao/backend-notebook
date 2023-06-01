package com.jeanne.lowcode.searchservice;

import com.jeanne.lowcode.searchservice.aspect.aspectj.ShouldBeConfiguredBySpring;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jeanne 2023/5/31
 **/
@Slf4j
@SpringBootTest
public class AspectJTests {

    @Test
    public void injection() {
        try (AnnotationConfigApplicationContext context = new  AnnotationConfigApplicationContext(Config.class)) {
            ShouldBeConfiguredBySpring myObject = new ShouldBeConfiguredBySpring();
            assertThat(myObject.getName()).isEqualTo("Rod");
        }
    }

    //com.jeanne.lowcode.searchservice.aspect.aspectj
    @Configuration
    @ImportResource("classpath:xml/beanConfigurerTests-beans.xml")
    @EnableSpringConfigured
//    @EnableLoadTimeWeaving
    @EnableAspectJAutoProxy
    static class Config  implements LoadTimeWeavingConfigurer {

        @Override
        public LoadTimeWeaver getLoadTimeWeaver() {
            return new ReflectiveLoadTimeWeaver();
        }
    }
}
