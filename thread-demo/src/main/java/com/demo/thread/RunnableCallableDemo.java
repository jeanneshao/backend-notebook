package com.demo.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author Jeanne 2023/8/29
 **/
@Slf4j
public class RunnableCallableDemo {

    public static void main(String[] args) {
        Thread runnable = new Thread(new RunnableDemo());
        FutureTask task = new FutureTask<>(new CallableDemo());
        Thread callable = new Thread(task);
        runnable.start();
        callable.start();
//        try {
//            String result1 =(String) task.get(2, TimeUnit.SECONDS);
//        } catch (ExecutionException e) {
//            log.error("<======Catch Error======>", e);
//        } catch (InterruptedException e) {
//            log.error("<======Catch Error======>", e);
//        } catch (TimeoutException e) {
//            log.error("<======Catch Error======>", e);
//        }

        try {
            String result = (String) task.get();
            log.info("<=====result====>{}",result);
        } catch (InterruptedException e) {
            log.error("<======Catch Error======>", e);
        } catch (ExecutionException e) {
            log.error("<======Catch Error======>", e);
        }

    }

    public static class RunnableDemo implements Runnable{
        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(10000l);
            log.info("<===running===>");
        }
    }
    public static class CallableDemo implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(20000l);
            return "Hello Callable";
        }
    }
}
