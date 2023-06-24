package com.jeanne.lowcode.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jeanne 2023/6/24
 **/
@RestController
@RequestMapping("cors2")
public class CORSDemoController2  {

    @GetMapping
    public String empty() {
        return "cors cannot reach me~~";
    }

    @GetMapping("allow")
    public String allow() {
        return "allow~~";
    }


}
