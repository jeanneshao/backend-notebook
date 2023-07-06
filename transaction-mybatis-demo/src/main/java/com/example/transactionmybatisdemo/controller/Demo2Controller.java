package com.example.transactionmybatisdemo.controller;

import com.example.transactionmybatisdemo.service.Demo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/7/2
 **/
@RestController
@RequestMapping("transaction2")
public class Demo2Controller {
    @Autowired
    Demo2Service demo2Service;

    @PostMapping(":methodTransaction")
    public void methodTransaction(@RequestParam("fail") Boolean fail) {
        demo2Service.methodTransaction(fail);
    }
}
