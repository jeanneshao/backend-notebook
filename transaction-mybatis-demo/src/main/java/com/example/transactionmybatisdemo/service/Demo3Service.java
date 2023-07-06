package com.example.transactionmybatisdemo.service;

import com.example.transactionmybatisdemo.entity.DemoAsset;
import com.example.transactionmybatisdemo.exception.DemoException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

/**
 * @author Jeanne 2023/7/2
 **/
@Service
@Slf4j
public class Demo3Service {
    @Autowired
    DemoAssetService demoAssetService;
    @Autowired
    DemoExceptionService demoExceptionService;

    public void innerTransaction(boolean fail) throws DemoException {
        add();
        add2();
        if (fail) {
            throwException();
        }
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional
    public void nested() {
        add();
        try {
            demoExceptionService.nestedException();
        } catch (DemoException e) {
            log.error("DemoException",e.getMessage());
        }
        add();
    }
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional
    public void nested2() throws DemoException {
        demoExceptionService.nested();
        add();
        throw new RuntimeException();
    }
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional
    public void requireNew() {
        add();
        try {
            demoExceptionService.requireNewException();
        } catch (DemoException e) {
            log.error("DemoException",e.getMessage());
        }
        add();
    }
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional
    public void requireNew2() throws DemoException {
        demoExceptionService.requireNew();
        add();
        throw new RuntimeException();
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    public void stimulateUnexpectedRollbackException(boolean fail) throws DemoException {
        add2();
    }

    @Transactional(rollbackFor = {DemoException.class})
    public void stimulateUnexpectedRollbackException2(boolean fail) throws DemoException{
        demoExceptionService.add2();

    }

    @Transactional(rollbackFor = {RuntimeException.class})
    public void stimulateUnexpectedRollbackException3(boolean fail) {
        try {
            demoExceptionService.stimulateUnexpectedRollbackException2(fail);
        } catch (DemoException e) {
            log.error(e.getMessage());
        }
    }


    @Transactional()
    public void add() {
        DemoAsset demoAsset = new DemoAsset();
        demoAsset.setCreatedTime(System.currentTimeMillis());
        demoAsset.setName("Demo3Service::add" + System.currentTimeMillis());

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

    @Transactional(rollbackFor = {DemoException.class})
    public void add2() throws DemoException {
        add();
        throwException();
    }

    public void throwException() throws DemoException {
        throw new DemoException("Stimulated DemoException");
    }


}
