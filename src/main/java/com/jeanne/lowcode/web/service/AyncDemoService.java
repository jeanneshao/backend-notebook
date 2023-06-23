package com.jeanne.lowcode.web.service;

import com.jeanne.lowcode.web.vo.AyncDemoVo;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/6/23
 **/
@Service
public class AyncDemoService {
    public ThreadLocal<AyncDemoVo> ayncDemoVoThreadLocal;

    public void processDeferredResult()  {
        for (int i = 0; i < 500; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        ayncDemoVoThreadLocal.get().getDeferredResult().setResult("hello DeferredResult");
    }

}
