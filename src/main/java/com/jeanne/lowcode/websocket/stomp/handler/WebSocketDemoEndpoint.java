package com.jeanne.lowcode.websocket.stomp.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeanne.lowcode.websocket.stomp.vo.DemoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Jeanne 2023/6/25
 **/
@ServerEndpoint("/websocket/{sid}")
@Component
@Slf4j
public class WebSocketDemoEndpoint {
    @Autowired
    ObjectMapper jacksonObjectMapper;

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketDemoEndpoint> webSocketSet = new CopyOnWriteArraySet<WebSocketDemoEndpoint>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收sid
     */
    private String sid="";
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid) {
        this.session = session;
        //加入set中
        webSocketSet.add(this);
        //在线数加1
        addOnlineCount();
        log.info("有新窗口开始监听:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid=sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口"+sid+"的信息:"+message);
        for (WebSocketDemoEndpoint item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                log.error("IOException",e);
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误",error);
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText("received message: " + message);
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(DemoVo message) throws IOException {

        this.session.getBasicRemote().sendText(jacksonObjectMapper.writeValueAsString(message));
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(DemoVo message,@PathParam("sid") String sid) throws IOException {
        log.info("推送消息到窗口"+sid+"，推送内容:"+message);
        for (WebSocketDemoEndpoint item : webSocketSet) {
            try {
                if(sid==null) {
                    item.sendMessage(message);
                }else if(item.sid.equals(sid)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketDemoEndpoint.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketDemoEndpoint.onlineCount--;
    }
}
