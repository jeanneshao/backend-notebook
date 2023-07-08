package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoSelectWithBackendDTO;
import com.example.jpademo.services.DemoSelectWithBackendService;
import com.example.jpademo.vo.DemoSelectWithBackendQueryVO;
import com.example.jpademo.vo.DemoSelectWithBackendUpdateVO;
import com.example.jpademo.vo.DemoSelectWithBackendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoSelectWithBackend")
public class DemoSelectWithBackendController {

    @Autowired
    private DemoSelectWithBackendService demoSelectWithBackendService;

    @PostMapping
    public String save(@Valid @RequestBody DemoSelectWithBackendVO vO) {
        return demoSelectWithBackendService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoSelectWithBackendService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoSelectWithBackendUpdateVO vO) {
        demoSelectWithBackendService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoSelectWithBackendDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoSelectWithBackendService.getById(id);
    }

    @GetMapping
    public Page<DemoSelectWithBackendDTO> query(@Valid DemoSelectWithBackendQueryVO vO) {
        return demoSelectWithBackendService.query(vO);
    }
}
