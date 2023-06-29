package com.example.websocket.stomp.controller;

import com.example.websocket.stomp.vo.DemoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Map;

/**
 * @author Jeanne 2023/6/25
 **/
@Controller
public class StompDemoController {
    //    @Autowired
//    WebSocketService webSocketService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

//    @MessageMapping("/demo")
//    @SendTo({"/topic", "/queue"})
//    public String app(String requestMessage) {
//        System.out.println("app接收消息：" + requestMessage);
//
//        simpMessagingTemplate.convertAndSend("app接收消息：" + requestMessage);
//        return "app服务端接收到你发的：" + requestMessage;
//    }

    @MessageMapping("/demo")
    @SendTo({"/topic/demo"})
    public DemoVo demo(DemoVo in) {
        System.out.println("demo接收消息：" + in);
        in.setRemarks("demo handled " + in.getName());
        return in;
    }

    @MessageMapping("/demo2")
    @SendTo({"/topic/demo"})
    public DemoVo demo2(DemoVo in) {
        System.out.println("demo2接收消息：" + in);
        in.setRemarks("demo2 handled " + in.getName());
        return in;
    }

    @MessageMapping("/demo/{id}")
    @SendTo({"/topic/demo"})
    public DemoVo demo3(@DestinationVariable("id") Long id,
                        Message message,
                        MessageHeaders messageHeaders,
                        MessageHeaderAccessor messageHeaderAccessor,
                        SimpMessageHeaderAccessor simpMessageHeaderAccessor,
                        StompHeaderAccessor stompHeaderAccessor,
                        @Payload DemoVo paylod,
                        @Header SimpMessageType simpMessageType,
                        @Headers Map headerMap,
                        Principal principal,
                        DemoVo in) {
        System.out.println("demo3接收消息：" + in);
        in.setRemarks("demo3 handled " + in.getName());
        return in;
    }

    @MessageMapping("/s*")
    @SendTo({"/topic/demo"})
    public DemoVo s(DemoVo in) {
        System.out.println("s 接收消息：" + in);
        in.setRemarks("s handled " + in.getName());
        return in;
    }
 @MessageMapping("/ss*")
    @SendTo({"/topic/demo"})
    public DemoVo ss(DemoVo in) {
        System.out.println("ss 接收消息：" + in);
        in.setRemarks("ss handled " + in.getName());
        return in;
    }

    @MessageMapping("/s/**")
    @SendTo({"/topic/demo"})
    public DemoVo s2(DemoVo in) {
        System.out.println("s2 接收消息：" + in);
        in.setRemarks("s2 handled " + in.getName());
        return in;
    }


}
