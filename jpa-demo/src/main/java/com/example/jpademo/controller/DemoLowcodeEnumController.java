package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoLowcodeEnumDTO;
import com.example.jpademo.services.DemoLowcodeEnumService;
import com.example.jpademo.vo.DemoLowcodeEnumQueryVO;
import com.example.jpademo.vo.DemoLowcodeEnumUpdateVO;
import com.example.jpademo.vo.DemoLowcodeEnumVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoLowcodeEnum")
public class DemoLowcodeEnumController {

    @Autowired
    private DemoLowcodeEnumService demoLowcodeEnumService;

    @PostMapping
    public String save(@Valid @RequestBody DemoLowcodeEnumVO vO) {
        return demoLowcodeEnumService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoLowcodeEnumService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoLowcodeEnumUpdateVO vO) {
        demoLowcodeEnumService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoLowcodeEnumDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoLowcodeEnumService.getById(id);
    }

    @GetMapping
    public Page<DemoLowcodeEnumDTO> query(@Valid DemoLowcodeEnumQueryVO vO) {
        return demoLowcodeEnumService.query(vO);
    }
}
