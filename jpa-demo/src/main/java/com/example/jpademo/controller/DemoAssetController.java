package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoAssetDTO;
import com.example.jpademo.services.DemoAssetService;
import com.example.jpademo.vo.DemoAssetQueryVO;
import com.example.jpademo.vo.DemoAssetUpdateVO;
import com.example.jpademo.vo.DemoAssetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
public class DemoAssetController {

    @Autowired
    private DemoAssetService demoAssetService;

    @PostMapping
    public String save(@Valid @RequestBody DemoAssetVO vO) {
        return demoAssetService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        demoAssetService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody DemoAssetUpdateVO vO) {
        demoAssetService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoAssetDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return demoAssetService.getById(id);
    }

    @GetMapping
    public Page<DemoAssetDTO> query(@Valid DemoAssetQueryVO vO) {
        return demoAssetService.query(vO);
    }
}
