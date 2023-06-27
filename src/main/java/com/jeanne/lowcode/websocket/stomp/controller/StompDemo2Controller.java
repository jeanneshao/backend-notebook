package com.jeanne.lowcode.websocket.stomp.controller;

import com.jeanne.lowcode.websocket.stomp.vo.DemoException;
import com.jeanne.lowcode.websocket.stomp.vo.DemoVo;
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

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

/**
 * @author Jeanne 2023/6/25
 **/
@Controller
@MessageMapping("/demo2")
@SendTo({"/topic/demo"})
public class StompDemo2Controller {
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
    @MessageMapping("/")
    public DemoVo demo(DemoVo in) {
        System.out.println("2222demo接收消息：" + in);
        in.setRemarks("2222demo handled " + in.getName());
        return in;
    }

    @MessageMapping("/2")
    public DemoVo demo2(DemoVo in) {
        System.out.println("2222demo2接收消息：" + in);
        in.setRemarks("2222demo2 handled " + in.getName());
        return in;
    }

    @MessageMapping("/{id}")
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
        System.out.println("2222demo3接收消息：" + in);
        in.setRemarks("2222demo3 handled " + in.getName());
        return in;
    }

    @MessageMapping("/s*")
    public DemoVo s(DemoVo in) {
        System.out.println("2222s 接收消息：" + in);
        in.setRemarks("2222s handled " + in.getName());
        return in;
    }

    @MessageMapping("/ss*")
    public DemoVo ss(DemoVo in) {
        System.out.println("2222ss 接收消息：" + in);
        in.setRemarks("2222ss handled " + in.getName());
        return in;
    }

    @MessageMapping("/s/**")
    @SendTo({"/topic/s2"})
    public DemoVo s2(DemoVo in) {
        System.out.println("2222s2 接收消息：" + in);
        in.setRemarks("2222s2 handled " + in.getName());
        return in;
    }

    @MessageMapping("/error")
    @SendTo({"/topic/s2"})
    public DemoVo createError(DemoVo in) throws IOException {
        throw new IOException("Stimulated error");
    }

    @MessageExceptionHandler
    @SendTo({"/topic/s2"})
    public DemoException handleException(Exception exception) {
        DemoException demoException = DemoException.builder().message(exception.getMessage()).build();
        return demoException;
    }
}
