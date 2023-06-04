package com.jeanne.lowcode.searchservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/6/1
 **/
@Service
@Slf4j
//public class NotVeryUsefulService {
//public class NotVeryUsefulService extends CommonService implements NotVeryUsefulInterface {
public class NotVeryUsefulService extends CommonService2 implements NotVeryUsefulInterface {

    public String transfer() {
        log.info("<------------NotVeryUsefulService.transfer----------------------->");
        return "hello ";
    }

    public String transfer(int count) {
        if (count < 0) throw new IllegalArgumentException();
        log.info("<------------NotVeryUsefulService.transfer----------------------->");
        return "hello " + count;
    }

    public void within() {
        log.info("<------------NotVeryUsefulService.within----------------------->");
    }

    public void thisDemo() {
        log.info("<------------NotVeryUsefulService.thisDemo----------------------->");
    }


}
