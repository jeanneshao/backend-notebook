package com.demo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jeanne 2023/8/25
 **/
@Slf4j
public class ThreadStateDemo {
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {

                Thread currentThread = Thread.currentThread();
                Thread.State state = currentThread.getState();
                log.info("thread state 2 -{}===>{}", state);
                synchronized (lock) {
                    log.info("thread state 4 -{}===>{}", state);
                    lock.wait();
                    log.info("thread state 5 -{}===>{}", state);
                }
                synchronized (lock) {
                    log.info("thread state 6 -{}===>{}", state);
                    lock.wait(5000l);
                    log.info("thread state 7 -{}===>{}", state);
                }
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                log.error("<======Catch Error======>", e);
            }
        });

        Thread.State state = thread.getState();
        log.info("thread state 1===>{}", state);
        thread.start();

        try {
            for (int i = 0; i < 5; i++) {
                state = thread.getState();
                log.info("thread state 3 - {} ===>{}", i, state);
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            log.error("<======Catch Error======>", e);
        }
        synchronized (lock) {
            lock.notify();
            state = thread.getState();
        }
        log.info("thread state3===>{}", state);

        Thread.sleep(15000);
        state = thread.getState();
        log.info("thread state 9- {} ===>{}", state);
    }

}
