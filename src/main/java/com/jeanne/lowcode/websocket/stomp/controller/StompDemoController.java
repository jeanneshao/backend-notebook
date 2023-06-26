package com.jeanne.lowcode.websocket.stomp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/6/25
 **/
@RestController
public class StompDemoController {
//    @Autowired
//    WebSocketService webSocketService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @SubscribeMapping({"/t1/hello"})
    public String subscribeTime() {
        return "hello!";
    }

    @SubscribeMapping({"/t1/info/{classId}"})
    public String subscribeState(@DestinationVariable String classId) {
        return "班级消息推送订阅成功!";
    }

    @SubscribeMapping({"/t2/{name}/hello"})
    public String subscribeParam(@DestinationVariable String name) {
        return "你好!"+name;
    }

    @MessageMapping("/hello")
    @SendTo("/t2/hello")
    public String hello(String requestMessage) {
        System.out.println("接收消息：" + requestMessage);
        return "服务端接收到你发的："+requestMessage;
    }

    @GetMapping("/sendMsgToUser")
    public String sendMsgByUser(String name, String msg) {
        // /user/{name}/hello
        simpMessagingTemplate.convertAndSendToUser(name, "/hello", msg);
        return "success";
    }

    @GetMapping("/sendMsgToAll")
    public String sendMsgByAll(int classId, String msg) {
        // /topic/info/{classId}
        simpMessagingTemplate.convertAndSend("/topic/info/"+classId, msg);
        return "success";
    }

//    public void connect(){
//        DemoVo demoVo = DemoVo.builder().id(66l).name("first test").remarks("a very looooooong remark").build();
//        webSocketService.sendMessage(demoVo);
//    }

}
