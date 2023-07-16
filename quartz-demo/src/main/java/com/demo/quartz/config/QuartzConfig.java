package com.demo.quartz.config;

import com.demo.quartz.jobdetail.DemoJob;
import lombok.Data;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * @author Jeanne 2023/7/15
 **/
@Configuration
@ConfigurationProperties(prefix = "demo.quartz")
@Data
public class QuartzConfig {
    private String url;
    private String username;
    private String password;

    private String commonUrl;
    private String commonUsername;
    private String commonPassword;

//    @Bean
//    @QuartzDataSource
//    public DataSource quartzDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setUrl(url);
//        return dataSource;
//    }


    @Bean
    @QuartzDataSource
    public DataSource separateDataSource() {
        return DataSourceBuilder
                .create()
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url(commonUrl)
                .username(commonUsername)
                .password(commonPassword)
                .build();
    }

    @Bean
    public JobDetail demoJobDetail(){
        // Create a new instance of JobDetail
        JobDetail jobDetail = JobBuilder.newJob(DemoJob.class)
                .withIdentity("demoJob", "demoGroup")
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger demoJobTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob("demoJob", "demoGroup")
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        return trigger;
    }



}
