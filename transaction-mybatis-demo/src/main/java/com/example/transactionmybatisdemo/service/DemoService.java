package com.example.transactionmybatisdemo.service;

import com.example.transactionmybatisdemo.entity.DemoAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.security.SecureRandom;

/**
 * @author Jeanne 2023/7/2
 **/
@Service
@Transactional
public class DemoService {
    @Autowired
    DemoAssetService demoAssetService;
    @Autowired
    TransactionManager transactionManager;
    @Autowired
    EventService eventService;

    public void mannualRollback(Boolean fail) {
        add();
        add2();
        if (fail) TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        eventService.emit("DemoService::mannualRollback", "setRollbackOnly");
    }

    public void classTransaction(boolean fail) {
        add();
        add2();
        if (fail) {
            throwException();
        }
    }

    @Transactional
    public void methodTransaction(boolean fail) {
        add();
        add2();
        if (fail) {
            throwException();
        }
    }

    @Transactional()
    public void threadRun(Boolean fail) {
        new Thread(() -> {
            add();
            add2();
            if (fail)
                throwException();
        }).start();

    }


    public void add() {
        DemoAsset demoAsset = new DemoAsset();
        demoAsset.setCreatedTime(System.currentTimeMillis());
        demoAsset.setName("DemoService::ClassTransaction" + System.currentTimeMillis());

        SecureRandom ng = new SecureRandom();
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;  /* clear version        */
        randomBytes[6] |= 0x40;  /* set to version 4     */
        randomBytes[8] &= 0x3f;  /* clear variant        */
        randomBytes[8] |= 0x80;  /* set to IETF variant  */

        demoAsset.setId(randomBytes);
        demoAssetService.save(demoAsset);

    }

    public void add2() {
        add();
    }

    public void throwException() throws RuntimeException {
        throw new RuntimeException("Stimulated Exception");
    }


}
