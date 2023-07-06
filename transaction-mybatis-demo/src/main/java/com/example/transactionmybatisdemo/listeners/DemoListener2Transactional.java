package com.example.transactionmybatisdemo.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalApplicationListener;
import org.springframework.transaction.event.TransactionalApplicationListenerAdapter;

/**
 * @author Jeanne 2023/7/6
 * 没生效，应该不是这么用的，是属于自己瞎来了
 **/
@Slf4j
@Component
public class DemoListener2Transactional extends TransactionalApplicationListenerAdapter<DemoEvent> implements TransactionalApplicationListener<DemoEvent> {

    
    /**
     * Construct a new TransactionalApplicationListenerAdapter.
     *
     * @param targetListener the actual listener to invoke in the specified transaction phase
     * @see #setTransactionPhase
     * @see TransactionalApplicationListener#forPayload
     */
    @Lazy
    public DemoListener2Transactional(@Qualifier("demoListener2Transactional") ApplicationListener<DemoEvent> targetListener) {
        super(targetListener);
    }

    public void onApplicationEvent(DemoEvent event) {
        log.info("<--------------------DemoListener2Transactional::onApplicationEvent-------------------->" + event);
    }
}

