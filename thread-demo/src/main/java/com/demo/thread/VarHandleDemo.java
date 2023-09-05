package com.demo.thread;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Jeanne 2023/8/30
 **/
@Slf4j
public class VarHandleDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        new Thread(new VarHandleRunnable()).start();
    }

    public static class DemoRunnable implements Runnable {

        @Override
        public void run() {

        }
    }


    public static class DemoVo {
        long id;
        String name;
    }

    public static class VarHandleRunnable extends DemoRunnable {
        private int counter = 0;
        private DemoVo demoVo = new DemoVo();
        private final VarHandle VAR_HANDLE = MethodHandles.lookup().findVarHandle(VarHandleRunnable.class, "counter", int.class);
        private final VarHandle DemoVoHANDLE = MethodHandles.lookup().findVarHandle(VarHandleRunnable.class, "demoVo", DemoVo.class);
        private final VarHandle DemoVoIdHANDLE = MethodHandles.lookup().findVarHandle(DemoVo.class, "id", long.class);

        public VarHandleRunnable() throws NoSuchFieldException, IllegalAccessException {
        }

        @Override
        public void run() {
            // Perform atomic increment using VarHandle
            VAR_HANDLE.getAndAdd(this, 1);
            System.out.println("counter: " + counter);
//            compareAndSet();
//            compareAndExchange();
////            VAR_HANDLE.accessModeType(VarHandle.AccessMode.COMPARE_AND_EXCHANGE);
//            VAR_HANDLE.compareAndExchangeAcquire();
//            coordinateTypes();
//            getAndBitwiseAnd();

        }

        public void get(){
            // Print the updated value
            int value = (int) VAR_HANDLE.get(this);
            System.out.println("counter: " + counter);
            System.out.println("Counter value: " + value);
        }
        public void compareAndSet(){
            // Perform atomic compare-and-set using VarHandle
            boolean success = VAR_HANDLE.compareAndSet(this, 3, 10);
            System.out.println("Compare-and-set success: " + success);
            System.out.println("counter: " + counter);

            success = VAR_HANDLE.compareAndSet(this, 1, 10);
            System.out.println("Compare-and-set success: " + success);
            System.out.println("counter: " + counter);

        }
        public void compareAndExchange(){
            /**
             *    - The release memory ordering semantics ensure that subsequent read or write operations on other variables see the updated value.
             */
            Object original = VAR_HANDLE.compareAndExchangeRelease(this, 5, 7);
            System.out.println("counter: " + counter);
            System.out.println("original value: " + original);
            original = VAR_HANDLE.compareAndExchangeRelease(this, 10, 6);
            System.out.println("counter: " + counter);
            System.out.println("original value: " + original);

            original = VAR_HANDLE.compareAndExchange(this, 5, 7);
            System.out.println("counter: " + counter);
            System.out.println("original value: " + original);
            original = VAR_HANDLE.compareAndExchange(this, 6, 8);
            System.out.println("counter: " + counter);
            System.out.println("original value: " + original);
        }
        public void coordinateTypes(){
            List<Class<?>> classes = VAR_HANDLE.coordinateTypes();
            log.info("coordinateTypes:------>{}",classes);

            List<Class<?>> classes2 = DemoVoHANDLE.coordinateTypes();
            log.info("DemoVoHANDLE:------>{}",classes2);

            List<Class<?>> classes3 = DemoVoIdHANDLE.coordinateTypes();
            log.info("DemoVoIdHANDLE:------>{}",classes3);


        }
        public void getAndBitwiseAnd(){
            VAR_HANDLE.set(this, 2);
            Object result = VAR_HANDLE.getAndBitwiseAnd(this, 7);
            log.info("counter===>{}<====>rsult====>{}",counter,result);
            VAR_HANDLE.set(this, 10);
            result = VAR_HANDLE.getAndBitwiseAnd(this, 8);
            log.info("counter===>{}<====>rsult====>{}",counter,result);
            result = VAR_HANDLE.getAndBitwiseAnd(this, 10);
            log.info("counter===>{}<====>rsult====>{}",counter,result);

        }
    }
}
