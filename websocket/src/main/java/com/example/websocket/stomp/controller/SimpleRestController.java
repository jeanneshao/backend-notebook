package com.example.websocket.stomp.controller;

import com.example.websocket.stomp.vo.DemoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jeanne 2023/6/27
 **/
@Controller
@RequestMapping("trigger")
public class SimpleRestController {
    @Autowired
    private SimpMessagingTemplate template;//名字的话是brokerMessagingTemplate

    @GetMapping("{greeting}")
    public void triggerMessage(@PathVariable String greeting) {
        DemoVo demoVo = DemoVo.builder().id(11l).name(greeting).remarks("SimpleRestController.triggerMessage: " + greeting).build();
        this.template.convertAndSend("/topic/s2", demoVo);
    }
}
