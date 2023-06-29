package com.example.web.controller;

import com.example.web.service.AyncDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;

/**
 * @author Jeanne 2023/6/23
 **/
@RestController
@RequestMapping("streaming")
public class StreamingDemoController {
    @Resource
    AyncDemoService service;

    ThreadGroup threadGroup = new ThreadGroup("StreamingDemoController");

    @GetMapping("/events")
    public ResponseBodyEmitter handle() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        new Thread(threadGroup,
                ()->{
                    service.streamEmit(emitter);
                },
                "deferredResult" )
                .start();
        return emitter;
    }

    @GetMapping("/sse")
    public SseEmitter handleSse() {
        SseEmitter emitter = new SseEmitter();
        new Thread(threadGroup,
                ()->{
                    service.streamEmit(emitter);
                },
                "deferredResult" )
                .start();
        return emitter;
    }

}
