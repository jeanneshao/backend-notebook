package com.jeanne.lowcode.searchservice.aspect.introduction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jeanne 2023/5/30
 **/
@Slf4j
public class DemoInterfaceImpl implements DemoInterface {
    @Override
    public void run() {
        log.info("<---------------->DemoInterfaceImpl run<---------------->");
    }
}
