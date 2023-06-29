package com.example.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.example.web.vo.JsonViewVo;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/6/22
 **/
@RestController
public class JsonViewController {
    @GetMapping("/user")
    @JsonView(JsonViewVo.WithoutPasswordView.class)
    public JsonViewVo getUser() {
        return new JsonViewVo("eric", "7!jd#h23", 21l);
    }

    @GetMapping("/user1")
    public MappingJacksonValue getUser1() {
        JsonViewVo jsonViewVo = new JsonViewVo("eric", "7!jd#h23", 21l);
        MappingJacksonValue value = new MappingJacksonValue(jsonViewVo);
        value.setSerializationView(JsonViewVo.WithoutPasswordView.class);
        return value;
    }

    @GetMapping("/user2")
    @JsonView(JsonViewVo.WithPasswordView.class)
    public JsonViewVo getUser2() {
        return new JsonViewVo("eric", "7!jd#h23", 21l);
    }

    @GetMapping("/user3")
    public JsonViewVo getUser3() {
        return new JsonViewVo("eric", "7!jd#h23", 21l);
    }
}
