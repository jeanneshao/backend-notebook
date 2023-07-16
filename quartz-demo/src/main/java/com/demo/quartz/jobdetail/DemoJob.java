package com.demo.quartz.jobdetail;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/16
 **/
//@Component
@Slf4j
public class DemoJob  extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("DemoJob::execute");

    }
}
