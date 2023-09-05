package com.demo.thread;

import com.demo.thread.vo.DemoVo;

/**
 * @author Jeanne 2023/9/4
 **/
public class ThreadLocalDemo {
    public static void main(String[] args) {
        DemoThread1 demoThread1 = new DemoThread1();
        demoThread1.start();
//        DemoThread1 demoThread2 = new DemoThread1();
//        demoThread2.start();

    }

    public static class DemoThread1 extends Thread {
        @Override
        public void run() {
            ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
            stringThreadLocal.set("Hello World~");
            ThreadLocal<Object> demoVoLocal = new ThreadLocal<>();
            DemoVo demoVo = DemoVo.builder().id(333l).name("test ThreadLocal").build();
            demoVoLocal.set(demoVo);

            String s = stringThreadLocal.get();
            DemoVo o = (DemoVo) demoVoLocal.get();

            stringThreadLocal.set("hello again");
            demoVo = null;
            o = (DemoVo) demoVoLocal.get();
            s = stringThreadLocal.get();

            demoVoLocal.set(null);

            demoVoLocal.remove();
            stringThreadLocal.remove();


        }

    }
}
