package com.example.websocket.stomp.service;

import com.example.websocket.stomp.vo.DemoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @author zhangxy13@aisainfo-int.com
 * @since 2020-08-05
 */
//@Service
@Slf4j
public class WebSocketService {
    /**
     * 任务状态
     */
    private static final String TASK_STATE = "/queue/task/state";

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 发送websocket
     */
    public void sendMessage(DemoVo demoVo) {
        log.info("send message {{}}", demoVo);
        simpMessagingTemplate.convertAndSendToUser(
                demoVo.getId().toString(), TASK_STATE, demoVo);
    }
}
