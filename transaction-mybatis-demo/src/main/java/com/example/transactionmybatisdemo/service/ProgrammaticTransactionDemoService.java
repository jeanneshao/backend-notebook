package com.example.transactionmybatisdemo.service;

import com.example.transactionmybatisdemo.entity.DemoAsset;
import com.example.transactionmybatisdemo.exception.DemoException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.security.SecureRandom;

/**
 * @author Jeanne 2023/7/5
 **/
@Service
@Slf4j
public class ProgrammaticTransactionDemoService {
    @Autowired
    TransactionTemplate transactionTemplate;
    @Autowired
    DemoAssetService demoAssetService;

    @Autowired
    PlatformTransactionManager transactionManager;
    private TransactionTemplate customTransactionTemplate;

    public DemoAsset customTransactionTemplateDemo(Boolean runtimeFail, Boolean checkedException) {
        customTransactionTemplate = new TransactionTemplate(transactionManager);
        // the transaction settings can be set here explicitly if so desired
//        this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
        this.transactionTemplate.setTimeout(30); // 30 seconds
        // the code in this method runs in a transactional context
        return (DemoAsset) customTransactionTemplate.execute((TransactionCallback) status -> {

            DemoAsset demoAsset = addFailure(runtimeFail);
            try {
                throwDemoException(checkedException);
            } catch (DemoException e) {
                log.error("demo exception", e);
                status.setRollbackOnly();
            }
            return demoAsset;
        });
    }

    public void cutom2() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
// explicitly setting the transaction name is something that can be done only  programmatically
        def.setName("SomeTxName");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            // put your business logic here
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        transactionManager.commit(status);
    }

    public DemoAsset transactionTemplateDemo(Boolean runtimeFail, Boolean checkedException) {
        // the code in this method runs in a transactional context
        return (DemoAsset) transactionTemplate.execute((TransactionCallback) status -> {

            DemoAsset demoAsset = addFailure(runtimeFail);
            try {
                throwDemoException(checkedException);
            } catch (DemoException e) {
                log.error("demo exception", e);
                status.setRollbackOnly();
            }
            return demoAsset;
        });
    }

    public void transactionTemplateDemo2(Boolean runtimeFail, Boolean checkedException) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @SneakyThrows
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                addFailure(runtimeFail);
//                try {
                throwDemoException(checkedException);
//                } catch (DemoException e) {
//                    log.error("demo exception", e);
//                    status.setRollbackOnly();
//                }

            }
        });
    }

    public DemoAsset add() {
        DemoAsset demoAsset = new DemoAsset();
        demoAsset.setCreatedTime(System.currentTimeMillis());
        demoAsset.setName("ProgrammaticTransactionDemoService::add" + System.currentTimeMillis());

        SecureRandom ng = new SecureRandom();
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;  /* clear version        */
        randomBytes[6] |= 0x40;  /* set to version 4     */
        randomBytes[8] &= 0x3f;  /* clear variant        */
        randomBytes[8] |= 0x80;  /* set to IETF variant  */

        demoAsset.setId(randomBytes);
        demoAssetService.save(demoAsset);
        return demoAsset;

    }

    public DemoAsset addFailure(boolean fail) {
        DemoAsset add = add();
        if (fail)
            throw new RuntimeException("ProgramticTransactionDemoService Exception");
        return add;
    }

    public void throwDemoException(boolean fail) throws DemoException {
        if (fail)
            throw new DemoException("Programticall throws DemoException");
    }

}
