package com.jeanne.lowcode.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeanne 2023/6/23
 **/
public class DeferredResultDemoInterceptor<T> implements DeferredResultProcessingInterceptor, AsyncHandlerInterceptor {
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("");
    }
    public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult)
            throws Exception {
        System.out.println("");
    }

    public <T> void preProcess(NativeWebRequest request, DeferredResult<T> deferredResult)
            throws Exception {
        System.out.println("");
    }

    public <T> void postProcess(NativeWebRequest request, DeferredResult<T> deferredResult,
                                Object concurrentResult) throws Exception {
        System.out.println("");
    }

    public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult)
            throws Exception {

        return true;
    }

    public <T> boolean handleError(NativeWebRequest request, DeferredResult<T> deferredResult,
                                   Throwable t) throws Exception {

        return true;
    }

    public <T> void afterCompletion(NativeWebRequest request, DeferredResult<T> deferredResult)
            throws Exception {
        System.out.println("");
    }
}
