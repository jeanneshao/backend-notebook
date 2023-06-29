package com.jeanne.lowcode.ioc.packageinfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

/**
 * @author Jeanne 2023/6/17
 **/
@Configuration
public class PackageInfoConfiguration {
    public String text;

    @Nullable
    public Boolean aBoolean;

    @Bean
    public ConfBean confObj(){
        return new ConfBean();
    }

    public static class ConfBean {
        @Nullable
        public String beanText;
        public Boolean beanBoolean;

    }
}
