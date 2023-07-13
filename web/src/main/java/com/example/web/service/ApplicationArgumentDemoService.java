package com.example.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Jeanne 2023/7/11
 **/
@Service
@Slf4j
public class ApplicationArgumentDemoService {
    @Autowired
    ApplicationArguments applicationArguments;

    public void printArguments(){
        log.info("ApplicationArgumentDemoService::printArguments");
        applicationArguments.getNonOptionArgs().forEach(System.out::println);
        log.info("ApplicationArgumentDemoService::getSourceArgs");
        Arrays.stream(applicationArguments.getSourceArgs()).forEach(System.out::println);
    }

}
