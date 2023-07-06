package com.jeanne.lowcode.aopdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/5/30
 **/
@Service
@Slf4j
public class CommonService2 extends CommonService {
    public void doService(){
        log.info("<------CommonService-----doService------------->");
    }
}
