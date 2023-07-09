package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoCustomerDTO;
import com.example.jpademo.services.DemoCustomerService;
import com.example.jpademo.vo.DemoCustomerQueryVO;
import com.example.jpademo.vo.DemoCustomerUpdateVO;
import com.example.jpademo.vo.DemoCustomerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoCustomer")
public class DemoCustomerController {

    @Autowired
    private DemoCustomerService demoCustomerService;

    @PostMapping
    public String save(@Valid @RequestBody DemoCustomerVO vO) {
        return demoCustomerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        demoCustomerService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody DemoCustomerUpdateVO vO) {
        demoCustomerService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoCustomerDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return demoCustomerService.getById(id);
    }

    @GetMapping
    public Page<DemoCustomerDTO> query(@Valid DemoCustomerQueryVO vO) {
        return demoCustomerService.query(vO);
    }
}
