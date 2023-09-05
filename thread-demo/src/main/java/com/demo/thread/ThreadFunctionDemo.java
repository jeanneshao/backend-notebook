package com.demo.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jeanne 2023/8/30
 **/
@Slf4j
public class ThreadFunctionDemo {
    public static void main(String[] args) {
        daemonAndJoinDemo();
//        interruptDemo();
    }
    @SneakyThrows
    public static void interruptDemo(){
        Thread thread = new Thread(() -> {
            do {
                boolean isInterrupted = Thread.currentThread().isInterrupted();

                if(isInterrupted){
                    log.info("<===isInterrupted====>{}",isInterrupted);
                    log.info("<===isInterrupted====>{}",Thread.currentThread().isInterrupted());
                }

            } while (!Thread.currentThread().isInterrupted());
        },"IsInterrupted-0");
        Thread thread2 = new Thread(() -> {
            do {
                boolean interruted = Thread.interrupted();//会清楚中断状态
                if (interruted) {
                    log.info("<===interruted====>{}",interruted);
                    log.info("<===interruted====>{}",Thread.interrupted());
                }

            } while (!Thread.currentThread().isInterrupted());
        },"Interrupted-1");
        Thread thread3 = new Thread(()->{

        },"Cathch-2");
        thread.start();
        thread2.start();
        thread3.start();
        Thread.sleep(2000);
        thread.interrupt();
        thread2.interrupt();

    }


    public static void daemonAndJoinDemo(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 150; i++) {
//                try {
                    log.info("Demo-1===>{}",i);
//                    Thread.yield();
//                } catch (InterruptedException e) {
//                    log.error("<======Thread Catch Error======>", e);
//                    Thread.currentThread().interrupt();
//                }
            }

        });
        thread.setName("Demo-1");
        thread.setDaemon(true); // 必须在start之前
        thread.start();
        System.out.println(thread.isAlive());
        ClassLoader contextClassLoader = thread.getContextClassLoader();
        log.info("contextClassLoader===>{}",contextClassLoader);

        thread.interrupt();
//        boolean interrupted = thread.isInterrupted();
//        thread.interrupted();

        join(thread);

//        timedJoin(thread);
    }
    public static void timedJoin(Thread thread){
        try {
            thread.join(2000,100);
        } catch (InterruptedException e) {
            log.error("<======Catch Error======>", e);
        }
    }
    public static void join(Thread thread){
        // 不推荐这样做，会有偶发场景，误发生notify，但是实际上并没有做完
        // 来源：Object.wait注释
        /**
         * For more information on this topic, see section 14.2,
         *      * "Condition Queues," in Brian Goetz and others' <em>Java Concurrency
         *      * in Practice</em> (Addison-Wesley, 2006) or Item 69 in Joshua
         *      * Bloch's <em>Effective Java, Second Edition</em> (Addison-Wesley,
         *      * 2008).
         */
        try {
            // 底层是Object.wait, join是一个synchronized方法，notify是虚拟机自动执行的
            thread.join();
            log.info("<-----------join over ------------>");
        } catch (InterruptedException e) {
            log.error("<======join Catch Error======>", e);
        }

    }

}
