package com.demo.security.controller;

import com.demo.security.vo.DemoVO;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Jeanne 2023/7/17
 **/
@RestController
@RequestMapping("skipAuth")
@CrossOrigin
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

    @GetMapping("hasPermission")
    @PreAuthorize("hasPermission(#demoVO, 'admin')")
    public String hasPermission(@RequestBody DemoVO demoVO){
        return "OK";
    }

    @GetMapping("hasPermission2")
    @PreAuthorize("#demoVO.name == 'hellllo'")
    public String hasPermissionP( @P("demoVO") @RequestBody DemoVO demoVO) {
        return "OK";
    }
    @GetMapping("hasPermission6")
    @PreAuthorize("#demoVO.name == 'hellllo'")
    public DemoVO hasPermissionArgument( @RequestBody DemoVO demoVO) {
        return demoVO;
    }
    @GetMapping("hasPermission3")
    @PreAuthorize("authentication.authorities.size() == #demoVO.authority")
    public String hasPermissionAuthentication( @RequestBody DemoVO demoVO) {
        return "OK";
    }

    @GetMapping("hasPermission4")
    public String hasPermissionGet(@RequestBody DemoVO demoVO) {
        return "OK";
    }
    @PostMapping("hasPermission4")
    public String hasPermissionPost(@RequestBody DemoVO demoVO) {
        return "OK";
    }

    @GetMapping("postFilter")
    @PostFilter("filterObject.authority > 0")
    public List<DemoVO> postFilter(){
        ArrayList<DemoVO> demoVOS = new ArrayList<>();
        DemoVO test1 = DemoVO.builder().id(1l).name("test1").authority(0).build();
        DemoVO test2 = DemoVO.builder().id(2l).name("test2").authority(1).build();
        DemoVO test3 = DemoVO.builder().id(3l).name("test3").authority(2).build();
        DemoVO test4 = DemoVO.builder().id(4l).name("test4").authority(3).build();
        DemoVO test5 = DemoVO.builder().id(4l).name("test5").authority(0).build();
        demoVOS.add(test1);
        demoVOS.add(test2);
        demoVOS.add(test3);
        demoVOS.add(test4);
        demoVOS.add(test5);

        return demoVOS;

    };
}
