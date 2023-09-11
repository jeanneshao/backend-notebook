package com.demo.thread;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jeanne 2023/9/11
 **/
public class SyncLockDemo {
    static Object lock = new Object();
    static AtomicBoolean shouldLock = new AtomicBoolean(false);

    @SneakyThrows
    public static void main(String[] args)  {
        SyncLockThread thread1 = new SyncLockThread("SyncLockThread-1");
        SyncLockThread thread2 = new SyncLockThread("SyncLockThread-2");
        thread1.start();
        Thread.sleep(1000l);
        thread2.start();
        Thread.sleep(1000l);

        thread2.interrupt();
        Thread.sleep(2000l);

        shouldLock.compareAndSet(true, false);//要求释放锁
        Thread.sleep(2000l);
        shouldLock.compareAndSet(true, false);//要求释放锁

        thread1.join();
        thread2.join();
    }

    static class SyncLockThread extends Thread {
        int count = 0;
        SyncLockThread(String threadName){
            super(threadName);
        }

        @Override
        public void run() {
            synchronized (lock){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(String.format("%s isInterrupted",getName()));
                    return;
                }

                System.out.println(String.format("%s obtained the lock",getName()));
                shouldLock.compareAndSet(false, true);
                while (shouldLock.get()) {
                    if(count == 0)
                        System.out.println(String.format("%s is working %d", getName(), count));
                    count++;
                }
                System.out.println(String.format("%s released the lock",getName()));

            }
            System.out.println(String.format("%s comes to the end",getName()));

        }
    }
}
