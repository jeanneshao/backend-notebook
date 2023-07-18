package com.demo.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author Jeanne 2023/7/17
 **/
@RestController
@RequestMapping("skipAuth")
public class AuthorizationController {

    @GetMapping("test")
    public Authentication getAuthentication(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.
                getAuthorities();
        return authentication;
    }

    @GetMapping("hasRole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hasRole(){
        return "OK";
    }

    @GetMapping("hasAnyRole")
    @PreAuthorize("hasAnyRole('ADMIN','ROLE_USER')")
    public String hasAnyRole(){
        return "OK";
    }
}
