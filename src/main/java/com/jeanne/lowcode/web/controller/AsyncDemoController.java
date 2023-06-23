package com.jeanne.lowcode.web.controller;

import com.jeanne.lowcode.web.service.AyncDemoService;
import com.jeanne.lowcode.web.vo.AyncDemoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.util.concurrent.Callable;

/**
 * @author Jeanne 2023/6/23
 **/
@RestController
public class AsyncDemoController {
    @Resource
    AyncDemoService service;

    ThreadGroup threadGroup = new ThreadGroup("AsyncDemoController");

    @GetMapping("/deferredResult")
    public DeferredResult<String> deferredResult() {
        AyncDemoVo ayncDemoVo = new AyncDemoVo();
        service.ayncDemoVoThreadLocal.set(ayncDemoVo);
        DeferredResult<String> deferredResult = new DeferredResult<>();
        ayncDemoVo.setDeferredResult(deferredResult);
        new Thread(threadGroup,
                service::processDeferredResult,
                "deferredResult" )
                .start();

        return deferredResult;
    }

    @GetMapping("/callable")
    public Callable<String> callable() {
        return () -> "someView";
    }

    @GetMapping("startAsync")
    public String testStartAsync(ServletRequest servletRequest){
        servletRequest.startAsync();
        return "";
    }
}
