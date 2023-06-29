package com.example.web.service;

import com.example.web.vo.AyncDemoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;

/**
 * @author Jeanne 2023/6/23
 **/
@Service
@Slf4j
public class AyncDemoService {
    public ThreadLocal<AyncDemoVo> ayncDemoVoThreadLocal = new ThreadLocal<>();
    public ThreadLocal<ResponseBodyEmitter> emitterThreadLocal = new ThreadLocal<>();

    public void processDeferredResult(AyncDemoVo ayncDemoVo) {
        ayncDemoVoThreadLocal.set(ayncDemoVo);

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        ayncDemoVoThreadLocal.get().getDeferredResult().setResult("hello DeferredResult");
    }

    public void streamEmit(ResponseBodyEmitter emitter) {
        emitterThreadLocal.set(emitter);

        for (int i = 0; i < 10; i++) {
            try {
                // In some other thread
                emitter.send("Hello " + i);
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                log.error("emitter exception",e);
            }
        }
        try {
            emitter.send("Final Hello " );
            emitter.complete();
        } catch (IOException e) {
            log.error("emitter exception",e);
        }
    }

}
