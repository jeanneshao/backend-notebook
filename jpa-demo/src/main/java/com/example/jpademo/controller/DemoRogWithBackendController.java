package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoRogWithBackendDTO;
import com.example.jpademo.services.DemoRogWithBackendService;
import com.example.jpademo.vo.DemoRogWithBackendQueryVO;
import com.example.jpademo.vo.DemoRogWithBackendUpdateVO;
import com.example.jpademo.vo.DemoRogWithBackendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoRogWithBackend")
public class DemoRogWithBackendController {

    @Autowired
    private DemoRogWithBackendService demoRogWithBackendService;

    @PostMapping
    public String save(@Valid @RequestBody DemoRogWithBackendVO vO) {
        return demoRogWithBackendService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoRogWithBackendService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoRogWithBackendUpdateVO vO) {
        demoRogWithBackendService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoRogWithBackendDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoRogWithBackendService.getById(id);
    }

    @GetMapping
    public Page<DemoRogWithBackendDTO> query(@Valid DemoRogWithBackendQueryVO vO) {
        return demoRogWithBackendService.query(vO);
    }
}
