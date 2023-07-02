package com.example.transaction.service;

import com.example.transaction.entity.DemoAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author Jeanne 2023/7/2
 **/
@Service
@Transactional
public class DemoService {
    @Autowired
    DemoAssetService demoAssetService;

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
    public void threadRun() {
        new Thread(() -> {
            add();
            add2();
            throwException();
        }).start();

    }


    public void add() {
        DemoAsset demoAsset = new DemoAsset();
        demoAsset.setCreatedTime(System.currentTimeMillis());
        demoAsset.setName("DemoService::ClassTransaction" + System.currentTimeMillis());
        demoAsset.setId(UUID.randomUUID());
        this.demoAssetService.save(demoAsset);

    }

    public void add2() {
        add();
    }

    public void throwException() throws RuntimeException {
        throw new RuntimeException("Stimulated Exception");
    }


}
