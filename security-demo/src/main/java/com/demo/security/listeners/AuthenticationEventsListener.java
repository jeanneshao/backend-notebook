package com.demo.security.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/7/17
 **/
@Component
@Slf4j
public class AuthenticationEventsListener {
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        log.info("AuthenticationEventsListener::onSuccess");
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failures) {
        log.info("AuthenticationEventsListener::onFailure");
    }
}
