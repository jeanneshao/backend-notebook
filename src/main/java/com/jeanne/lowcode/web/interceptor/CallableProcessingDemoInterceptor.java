package com.jeanne.lowcode.web.interceptor;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

/**
 * @author Jeanne 2023/6/23
 **/
public class CallableProcessingDemoInterceptor<T> implements CallableProcessingInterceptor , AsyncHandlerInterceptor {
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("");
    }

    public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
        System.out.println("");
    }

    public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
        System.out.println("");
    }

    public <T> void postProcess(NativeWebRequest request, Callable<T> task,
                                Object concurrentResult) throws Exception {
        System.out.println("");
    }

    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
        System.out.println("");
        return RESULT_NONE;
    }

    public <T> Object handleError(NativeWebRequest request, Callable<T> task, Throwable t) throws Exception {
        System.out.println("");
        return RESULT_NONE;
    }

    public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
        System.out.println("");
    }
}
