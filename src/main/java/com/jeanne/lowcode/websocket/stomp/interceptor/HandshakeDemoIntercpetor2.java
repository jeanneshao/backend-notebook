package com.jeanne.lowcode.websocket.stomp.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.server.RequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.ServletContext;

/**
 * @author Jeanne 2023/6/25
 **/
@Slf4j
public class HandshakeDemoIntercpetor2 extends DefaultHandshakeHandler {

    @Override
    public void setServletContext(ServletContext servletContext) {
        RequestUpgradeStrategy strategy = getRequestUpgradeStrategy();
        if (strategy instanceof ServletContextAware) {
            ((ServletContextAware) strategy).setServletContext(servletContext);
        }
    }

}
