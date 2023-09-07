package com.demo;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jeanne 2023/9/6
 **/
public class ReentrantLockDemo {
    static int num = 0;
    static AtomicBoolean shouldLock = new AtomicBoolean(false);

    public static void main(String[] args) {
//        simpleDemo(true);
//        simpleDemo(false);

//        System.out.println("====================fair=======================");
//        test(true);
//        System.out.println("====================non fair======================");
//        test(false);

        System.out.println("====================可中断======================");
        interruptDemo(true);
        System.out.println("====================不可中断======================");
        interruptDemo(false);
    }

    @SneakyThrows
    public static void interruptDemo(boolean interruptibly) {
        InterruptDemoThread thread1 = new InterruptDemoThread("Thread-1", interruptibly);
        InterruptDemoThread thread2 = new InterruptDemoThread("Thread-2", interruptibly);

        thread1.start();
        Thread.sleep(1000l);
        thread2.start();
        Thread.sleep(1000l);

        thread2.interrupt();
        Thread.sleep(2000l);
        shouldLock.compareAndSet(true, false);//要求释放锁

        thread1.join();
        thread2.join();

    }

    @Slf4j
    static class InterruptDemoThread extends Thread {
        public InterruptDemoThread(String name, boolean interruptibly) {
            super(null, null, name, 0);
            this.interruptibly = interruptibly;
        }

        static ReentrantLock lock = new ReentrantLock();
        boolean interruptibly;

        public void run() {
            try {
                if (interruptibly) {
                    lock.lockInterruptibly();
                } else {
                    lock.lock();
                }
                System.out.println(String.format("%s got the lock", getName()));
                shouldLock.compareAndSet(false, true);
            } catch (InterruptedException e) {
                log.error("<======Lock Catch InterruptedException======>");
            }

            try {
                while (shouldLock.get()) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                log.error("<======Sleep Catch InterruptedException======>");
            } finally {
                if (lock.isLocked() ) {
                    try {
                        lock.unlock();
                        System.out.println(String.format("%s released the lock", getName()));
                    } catch (IllegalMonitorStateException illegalMonitorStateException){

                    }
                }
            }
            System.out.println(String.format("%s comes to the end", getName()));

        }
    }

    @SneakyThrows
    public static void simpleDemo(boolean fair) {
        FairLockThread fairLockThread = new FairLockThread("FairLockThread-1", fair);
        fairLockThread.start();
    }

    @SneakyThrows
    public static void test(boolean fair) {
        FairLockThread fairLockThread = new FairLockThread("FairLockThread-1", fair);
        FairLockThread fairLockThread2 = new FairLockThread("FairLockThread-2", fair);
        FairLockThread fairLockThread3 = new FairLockThread("FairLockThread-3", fair);
        FairLockThread fairLockThread4 = new FairLockThread("FairLockThread-4", fair);
        FairLockThread fairLockThread5 = new FairLockThread("FairLockThread-5", fair);
        fairLockThread.start();
        Thread.sleep(1000l);
        fairLockThread2.start();
        Thread.sleep(1000l);
        fairLockThread3.start();
        Thread.sleep(1000l);
        fairLockThread4.start();
        Thread.sleep(1000l);
        fairLockThread5.start();
        fairLockThread.join();
        fairLockThread2.join();
        fairLockThread3.join();
        fairLockThread4.join();
        fairLockThread5.join();
        System.out.println(num);
    }

    @Data
    static class FairLockThread extends Thread {
        public FairLockThread(String name, boolean fair) {
            super(null, null, name, 0);
            lock = fair ? fairLock : nonFairLock;
        }

        static ReentrantLock fairLock = new ReentrantLock(true);
        static ReentrantLock nonFairLock = new ReentrantLock();
        ReentrantLock lock;

        @SneakyThrows
        @Override
        public void run() {
            lock.lock();
            System.out.println(String.format("%s starts to accululate", getName()));
            for (int i = 0; i < 1000000; i++) {
                num++;
            }
            System.out.println(String.format("%s finish", getName()));
            Thread.sleep(1000l);
            lock.unlock();

        }

    }

}
