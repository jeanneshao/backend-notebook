package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoFullExampleDTO;
import com.example.jpademo.services.DemoFullExampleService;
import com.example.jpademo.vo.DemoFullExampleQueryVO;
import com.example.jpademo.vo.DemoFullExampleUpdateVO;
import com.example.jpademo.vo.DemoFullExampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoFullExample")
public class DemoFullExampleController {

    @Autowired
    private DemoFullExampleService demoFullExampleService;

    @PostMapping
    public String save(@Valid @RequestBody DemoFullExampleVO vO) {
        return demoFullExampleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoFullExampleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoFullExampleUpdateVO vO) {
        demoFullExampleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoFullExampleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoFullExampleService.getById(id);
    }

    @GetMapping
    public Page<DemoFullExampleDTO> query(@Valid DemoFullExampleQueryVO vO) {
        return demoFullExampleService.query(vO);
    }
}
