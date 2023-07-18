package com.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/7/16
 **/
@RestController
@RequestMapping("security")
public class DemoController {
    @GetMapping
    public String demo(){
        return "Hello Spring Security";
    }
}
