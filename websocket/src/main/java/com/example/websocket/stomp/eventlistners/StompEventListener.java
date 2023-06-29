package com.example.websocket.stomp.eventlistners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

/**
 * @author Jeanne 2023/6/29
 **/
@Component
@Slf4j
public class StompEventListener {

    @EventListener(BrokerAvailabilityEvent.class)
    public void listenToBrokerAvailabilityEvent(BrokerAvailabilityEvent event) {
        log.info("BrokerAvailabilityEvent,{}", event);
    }

    @EventListener(SessionConnectEvent.class)
    public void listenToSessionConnectEvent(SessionConnectEvent event) {
        log.info("SessionConnectEvent,{}", event);
    }

    @EventListener(SessionConnectedEvent.class)
    public void listenToSessionConnectedEvent(SessionConnectedEvent event) {
        log.info("SessionConnectedEvent,{}", event);
    }

    @EventListener(SessionSubscribeEvent.class)
    public void listenToSessionSubscribeEvent(SessionSubscribeEvent event) {
        log.info("SessionSubscribeEvent,{}", event);
    }

    @EventListener(SessionUnsubscribeEvent.class)
    public void listenToSessionUnsubscribeEvent(SessionUnsubscribeEvent event) {
        log.info("SessionUnsubscribeEvent,{}", event);
    }

    @EventListener(SessionDisconnectEvent.class)
    public void listenToSessionDisconnectEvent(SessionDisconnectEvent event) {
        log.info("SessionDisconnectEvent,{}", event);
    }


}
