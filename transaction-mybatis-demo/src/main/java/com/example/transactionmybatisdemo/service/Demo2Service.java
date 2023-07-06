package com.example.transactionmybatisdemo.service;

import com.example.transactionmybatisdemo.entity.DemoAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

/**
 * @author Jeanne 2023/7/2
 **/
@Service
public class Demo2Service {
    @Autowired
    DemoAssetService demoAssetService;

    public void methodTransaction(boolean fail) {
        add2(fail);

    }

    public void add() {
        DemoAsset demoAsset = new DemoAsset();
        demoAsset.setCreatedTime(System.currentTimeMillis());
        demoAsset.setName("DemoService::ClassTransaction" + System.currentTimeMillis());

        SecureRandom ng = new SecureRandom();
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6]  &= 0x0f;  /* clear version        */
        randomBytes[6]  |= 0x40;  /* set to version 4     */
        randomBytes[8]  &= 0x3f;  /* clear variant        */
        randomBytes[8]  |= 0x80;  /* set to IETF variant  */

        demoAsset.setId(randomBytes);
        demoAssetService.save(demoAsset);

    }

    @Transactional
    public void add2(Boolean fail) {
        add();
        if (fail) {
            throwException();
        }
    }

    public void throwException() throws RuntimeException {
        throw new RuntimeException("Stimulated Exception");
    }


}
