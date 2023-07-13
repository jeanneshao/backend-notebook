package com.example.web.exithooks;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jeanne 2023/7/12
 **/
@Configuration
public class ExitCodeGeneratorConfig {
    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }
}
