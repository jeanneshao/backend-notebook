package com.demo.security.controller;

import com.demo.security.service.MethodSecurityService;
import com.demo.security.vo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

/**
 * @author Jeanne 2023/7/20
 **/
@RestController
@Slf4j
@RequestMapping("method")
public class MethodSecurityController {
    @Autowired
    MethodSecurityService methodSecurityService;

    @GetMapping("read")
    public DemoVO read(Long id) {
        log.info("MethodSecurityController::read");
        return methodSecurityService.read(id);
    }

    @GetMapping("read2")
    public DemoVO read2(Long id) {
        log.info("MethodSecurityController::read");
        return methodSecurityService.read2(id);
    }

    @GetMapping("find")
    public DemoVO[] find() {
        log.info("MethodSecurityController::find");
        return methodSecurityService.find();
    }

    @GetMapping("post")
    public DemoVO post(DemoVO account) {
        log.info("MethodSecurityController::post");
        return methodSecurityService.post(account);
    }

    @GetMapping("rulesAllowed")
    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    public String rulesAllowed() {
        return "OK";
    }

    @GetMapping("DenyAll")
    @DenyAll
    public void denyAll() {
        // Method implementation
    }

    @GetMapping("PermitAll")
    @PermitAll
    public void permitAll() {
        // Method implementation
    }


}
