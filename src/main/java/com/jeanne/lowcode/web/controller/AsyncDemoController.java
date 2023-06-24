package com.jeanne.lowcode.web.controller;

import com.jeanne.lowcode.web.interceptor.CallableProcessingDemoInterceptor;
import com.jeanne.lowcode.web.interceptor.DeferredResultDemoInterceptor;
import com.jeanne.lowcode.web.service.AyncDemoService;
import com.jeanne.lowcode.web.vo.AyncDemoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.servlet.FrameworkServlet;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.util.concurrent.Callable;

import static org.springframework.web.context.request.async.WebAsyncUtils.WEB_ASYNC_MANAGER_ATTRIBUTE;

/**
 * @author Jeanne 2023/6/23
 **/
@RestController
@RequestMapping("async")
public class AsyncDemoController {
    @Resource
    AyncDemoService service;

    ThreadGroup threadGroup = new ThreadGroup("AsyncDemoController");

    @GetMapping("/deferredResult")
    public DeferredResult<String> deferredResult(WebRequest webRequest) {
        AyncDemoVo ayncDemoVo = new AyncDemoVo();
        DeferredResult<String> deferredResult = new DeferredResult<>();
        ayncDemoVo.setDeferredResult(deferredResult);
//        WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(webRequest);
//        asyncManager.registerDeferredResultInterceptor(DeferredResultDemoInterceptor.class.getName(), new DeferredResultDemoInterceptor());

        new Thread(threadGroup,
                ()->{
                    service.processDeferredResult(ayncDemoVo);
                },
                "deferredResult" )
                .start();

        return deferredResult;
    }

    @GetMapping("/callable")
    public Callable<String> callable(WebRequest webRequest) {
//        WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(webRequest);
//        asyncManager.registerCallableInterceptor(CallableProcessingDemoInterceptor.class.getName(), new CallableProcessingDemoInterceptor());
        return () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            return "someView";
        };
    }

    @GetMapping("startAsync")
    public String testStartAsync(ServletRequest servletRequest){
        servletRequest.startAsync();
        return "";
    }
}
