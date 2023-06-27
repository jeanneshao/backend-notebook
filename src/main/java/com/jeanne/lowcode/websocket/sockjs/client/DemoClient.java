package com.jeanne.lowcode.websocket.sockjs.client;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeanne 2023/6/26
 **/
@Service
public class DemoClient {
    public void stimulateClients(){
        List<Transport> transports = new ArrayList<>(2);
        StandardWebSocketClient standardWebSocketClient = new StandardWebSocketClient();
        standardWebSocketClient.setTaskExecutor(new ThreadPoolTaskExecutor());
        transports.add(new WebSocketTransport(standardWebSocketClient));
        transports.add(new RestTemplateXhrTransport());
        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.doHandshake(new DemoClientHandler(), "ws://localhost:8080/websocket2");
    }
}
