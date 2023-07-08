package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoOneToOneExampleDTO;
import com.example.jpademo.services.DemoOneToOneExampleService;
import com.example.jpademo.vo.DemoOneToOneExampleQueryVO;
import com.example.jpademo.vo.DemoOneToOneExampleUpdateVO;
import com.example.jpademo.vo.DemoOneToOneExampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoOneToOneExample")
public class DemoOneToOneExampleController {

    @Autowired
    private DemoOneToOneExampleService demoOneToOneExampleService;

    @PostMapping
    public String save(@Valid @RequestBody DemoOneToOneExampleVO vO) {
        return demoOneToOneExampleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoOneToOneExampleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoOneToOneExampleUpdateVO vO) {
        demoOneToOneExampleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoOneToOneExampleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoOneToOneExampleService.getById(id);
    }

    @GetMapping
    public Page<DemoOneToOneExampleDTO> query(@Valid DemoOneToOneExampleQueryVO vO) {
        return demoOneToOneExampleService.query(vO);
    }
}
