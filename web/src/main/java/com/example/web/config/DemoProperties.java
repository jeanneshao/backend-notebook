package com.example.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/12
 **/
@ConfigurationProperties(prefix = "demo")
@Component
@Data
public class DemoProperties {
    private String name;
    private Long id;
    private String description;
    private Boolean extension;
}
