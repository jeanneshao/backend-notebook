package com.jeanne.lowcode.searchservice.aspect.aspectj;

import com.jeanne.lowcode.searchservice.service.CommonPointcuts;
import com.jeanne.lowcode.searchservice.service.CommonService;
import org.springframework.beans.factory.annotation.Autowire;
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
