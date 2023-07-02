package com.example.transaction.controller;

import com.example.transaction.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void threadTransaction(){
        demoService.threadRun();
    }
}
