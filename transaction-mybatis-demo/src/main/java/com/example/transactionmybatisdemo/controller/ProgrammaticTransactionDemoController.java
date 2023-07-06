package com.example.transactionmybatisdemo.controller;

import com.example.transactionmybatisdemo.entity.DemoAsset;
import com.example.transactionmybatisdemo.exception.DemoException;
import com.example.transactionmybatisdemo.service.DemoAssetService;
import com.example.transactionmybatisdemo.service.ProgrammaticTransactionDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

/**
 * @author Jeanne 2023/7/5
 **/
@RestController
@RequestMapping("programmatic")
@Slf4j
public class ProgrammaticTransactionDemoController {
    @Autowired
    ProgrammaticTransactionDemoService service;

    @GetMapping("customTransactionTemplate")
    public DemoAsset customTransactionTemplateDemo(@RequestParam(required = false,defaultValue = "false") Boolean runtimeFail,
                                             @RequestParam(required = false,defaultValue = "false") Boolean checkedException) {
        // the code in this method runs in a transactional context
        return service.customTransactionTemplateDemo(runtimeFail,checkedException);
    }

   @GetMapping("hasReturn")
    public DemoAsset transactionTemplateDemo(@RequestParam(required = false,defaultValue = "false") Boolean runtimeFail,
                                             @RequestParam(required = false,defaultValue = "false") Boolean checkedException) {
        // the code in this method runs in a transactional context
        return service.transactionTemplateDemo(runtimeFail,checkedException);
    }

    @GetMapping("hasNoReturn")
    public String transactionTemplateDemo2(@RequestParam(required = false,defaultValue = "false") Boolean runtimeFail,
                                           @RequestParam(required = false,defaultValue = "false") Boolean checkedException) {
        service.transactionTemplateDemo2(runtimeFail,checkedException);
        return "success";

    }



}
