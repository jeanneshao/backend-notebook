package com.example.transactionmybatisdemo.controller;

import com.example.transactionmybatisdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/7/2
 **/
@RestController
@RequestMapping("transaction")
public class DemoController {
    @Autowired
    DemoService demoService;

    @PostMapping(":classTransaction")
    public void classTransaction(@RequestParam("fail") Boolean fail) {
        demoService.classTransaction(fail);
    }
    @PostMapping(":methodTransaction")
    public void methodTransaction(@RequestParam("fail") Boolean fail) {
        demoService.methodTransaction(fail);
    }
    @PostMapping(":threadRun")
    public void threadTransaction(@RequestParam("fail") Boolean fail){
        demoService.threadRun(fail);
    }

    @PostMapping(":mannualRollback")
    public void mannualRollback(@RequestParam(value = "fail",required = false) Boolean fail){
        demoService.mannualRollback(fail);
    }
}
