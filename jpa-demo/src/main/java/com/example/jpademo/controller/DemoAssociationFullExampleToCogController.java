package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoAssociationFullExampleToCogDTO;
import com.example.jpademo.services.DemoAssociationFullExampleToCogService;
import com.example.jpademo.vo.DemoAssociationFullExampleToCogQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCogUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoAssociationFullExampleToCog")
public class DemoAssociationFullExampleToCogController {

    @Autowired
    private DemoAssociationFullExampleToCogService demoAssociationFullExampleToCogService;

    @PostMapping
    public String save(@Valid @RequestBody DemoAssociationFullExampleToCogVO vO) {
        return demoAssociationFullExampleToCogService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoAssociationFullExampleToCogService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoAssociationFullExampleToCogUpdateVO vO) {
        demoAssociationFullExampleToCogService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoAssociationFullExampleToCogDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoAssociationFullExampleToCogService.getById(id);
    }

    @GetMapping
    public Page<DemoAssociationFullExampleToCogDTO> query(@Valid DemoAssociationFullExampleToCogQueryVO vO) {
        return demoAssociationFullExampleToCogService.query(vO);
    }
}
