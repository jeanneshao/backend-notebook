package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoTbUserDTO;
import com.example.jpademo.services.DemoTbUserService;
import com.example.jpademo.vo.DemoTbUserQueryVO;
import com.example.jpademo.vo.DemoTbUserUpdateVO;
import com.example.jpademo.vo.DemoTbUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoTbUser")
public class DemoTbUserController {

    @Autowired
    private DemoTbUserService demoTbUserService;

    @PostMapping
    public String save(@Valid @RequestBody DemoTbUserVO vO) {
        return demoTbUserService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        demoTbUserService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody DemoTbUserUpdateVO vO) {
        demoTbUserService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoTbUserDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return demoTbUserService.getById(id);
    }

    @GetMapping
    public Page<DemoTbUserDTO> query(@Valid DemoTbUserQueryVO vO) {
        return demoTbUserService.query(vO);
    }
}
