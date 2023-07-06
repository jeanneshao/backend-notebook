package com.example.transactionmybatisdemo.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author Jeanne 2023/7/6
 **/
@Slf4j
@Component
public class DemoListeners {
    @EventListener({DemoEvent.class})
    public void  listenNormal(DemoEvent event){
        log.info("<--------------------DemoListeners::listenNormal-------------------->",event);
    }
    @TransactionalEventListener({DemoEvent.class})
    public void  listenTransactional(DemoEvent event){
        log.info("<--------------------DemoListeners::listenTransactional::TransactionPhase.AFTER_COMMIT-------------------->",event);
    }
    @TransactionalEventListener(value = {DemoEvent.class},phase = TransactionPhase.BEFORE_COMMIT)
    public void  listenTransactionalBeforeCommit(DemoEvent event){
        log.info("<--------------------DemoListeners::listenTransactional::TransactionPhase.BEFORE_COMMIT-------------------->",event);
    }
    @TransactionalEventListener(value = {DemoEvent.class},phase = TransactionPhase.AFTER_ROLLBACK)
    public void  listenTransactionalAFTERROLLBACK(DemoEvent event){
        log.info("<--------------------DemoListeners::listenTransactional::TransactionPhase.AFTER_ROLLBACK-------------------->",event);
    }
     @TransactionalEventListener(value = {DemoEvent.class},phase = TransactionPhase.AFTER_COMPLETION)
    public void  listenTransactionalAFTERCOMPLETION(DemoEvent event){
        log.info("<--------------------DemoListeners::listenTransactional::TransactionPhase.AFTER_COMPLETION-------------------->",event);
    }

}
