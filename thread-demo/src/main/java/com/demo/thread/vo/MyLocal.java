package com.demo.thread.vo;

import java.lang.ref.WeakReference;

/**
 * @author Jeanne 2023/9/4
 **/
public class MyLocal<S> extends WeakReference<MyLocal<?>> {
    /**
     * The value associated with this ThreadLocal.
     */
    Object value;
    WeakReference<MyLocal<?>> key;


    MyLocal(MyLocal<?> k, Object v) {
        super(k);
        key = new WeakReference<MyLocal<?>>(k);
        value = v;
    }

}
