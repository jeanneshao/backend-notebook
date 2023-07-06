package com.jeanne.lowcode.aopdemo.aspect.aspectj;

import com.jeanne.lowcode.aopdemo.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Jeanne 2023/5/30
 **/
@Configurable
public class Account {
    @Autowired // @Inject
    CommonService commonService;
    public void callService(){
        commonService.doService();
    }
}
