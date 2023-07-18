package com.demo.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.*;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Jeanne 2023/7/17
 **/
@Slf4j
@Component
@Order(0)
public class DemoFilter extends DelegatingFilterProxy {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("DemoFilter::doFilter");
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {
        log.info("DemoFilter::destroy");
        // Cleanup logic
    }
}
