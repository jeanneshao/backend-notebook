package com.demo.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeanne 2023/7/17
 **/
@Slf4j
@Order(-1)
public class Demo2Filter extends OncePerRequestFilter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("Demo2Filter::init");
//        // Initialization logic
//    }
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        log.info("Demo2Filter::doFilter");
//        // Filter logic
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        Authentication authentication =new UsernamePasswordAuthenticationToken("demo","demo");
////        Authentication authentication = new TestingAuthenticationToken("demo", "demo", "ROLE_USER");
//        context.setAuthentication(authentication);
//        SecurityContextHolder.setContext(context);
//        chain.doFilter(request, response);
//    }
//    @Override
//    public void destroy() {
//        log.info("Demo2Filter::destroy");
//        // Cleanup logic
//    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Demo2Filter::doFilter");
        String role = request.getHeader("role");
        role = StringUtils.hasText(role)? role : "ROLE_GUEST";
        // Filter logic
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        Authentication authentication =
                new UsernamePasswordAuthenticationToken("demo","demo",
                        Arrays.asList(new SimpleGrantedAuthority(role)));

        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        request.getSession(true).setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,context);

        filterChain.doFilter(request, response);

    }


}
