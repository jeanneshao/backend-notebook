package com.example.transactionmybatisdemo.controller;

import com.example.transactionmybatisdemo.exception.DemoException;
import com.example.transactionmybatisdemo.service.Demo3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/7/2
 **/
@RestController
@RequestMapping("transaction3")
public class Demo3Controller {
    @Autowired
    Demo3Service demo3Service;

    @PostMapping(":innerTransaction")
    public void innerTransaction(@RequestParam("fail") Boolean fail) throws DemoException {
        demo3Service.innerTransaction(fail);
    }

    @PostMapping(":UnexpectedRollbackException")
    public void stimulateUnexpectedRollbackException(@RequestParam("fail") Boolean fail) throws DemoException {
        demo3Service.stimulateUnexpectedRollbackException(fail);
    }

    @PostMapping(":UnexpectedRollbackException2")
    public void stimulateUnexpectedRollbackException2(@RequestParam("fail") Boolean fail) {
        demo3Service.stimulateUnexpectedRollbackException3(fail);
    }

    @PostMapping(":requireNew")
    public void requireNew() throws DemoException {
        demo3Service.requireNew();
    }

    @PostMapping(":requireNew2")
    public void requireNew2() throws DemoException {
        demo3Service.requireNew2();
    }

    @PostMapping(":nested")
    public void nested() throws DemoException {
        demo3Service.nested();
    }

    @PostMapping(":nested2")
    public void nested2() throws DemoException {
        demo3Service.nested2();
    }

}
