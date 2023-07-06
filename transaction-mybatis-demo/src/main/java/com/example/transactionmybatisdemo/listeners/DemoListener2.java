package com.example.transactionmybatisdemo.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/6
 **/
@Slf4j
@Component
public class DemoListener2  implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent event) {
        log.info("<--------------------DemoListener2::onApplicationEvent-------------------->" + event);
    }

}
