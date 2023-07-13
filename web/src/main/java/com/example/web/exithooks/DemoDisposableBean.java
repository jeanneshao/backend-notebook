package com.example.web.exithooks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author Jeanne 2023/7/12
 **/
@Component
@Slf4j
public class DemoDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("DemoDisposableBean::destroy");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("DemoDisposableBean::preDestroy");
    }
}
