package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoOneToManyExampleDTO;
import com.example.jpademo.services.DemoOneToManyExampleService;
import com.example.jpademo.vo.DemoOneToManyExampleQueryVO;
import com.example.jpademo.vo.DemoOneToManyExampleUpdateVO;
import com.example.jpademo.vo.DemoOneToManyExampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoOneToManyExample")
public class DemoOneToManyExampleController {

    @Autowired
    private DemoOneToManyExampleService demoOneToManyExampleService;

    @PostMapping
    public String save(@Valid @RequestBody DemoOneToManyExampleVO vO) {
        return demoOneToManyExampleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoOneToManyExampleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoOneToManyExampleUpdateVO vO) {
        demoOneToManyExampleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoOneToManyExampleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoOneToManyExampleService.getById(id);
    }

    @GetMapping
    public Page<DemoOneToManyExampleDTO> query(@Valid DemoOneToManyExampleQueryVO vO) {
        return demoOneToManyExampleService.query(vO);
    }
}
