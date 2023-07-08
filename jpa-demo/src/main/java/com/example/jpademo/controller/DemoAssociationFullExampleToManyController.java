package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoAssociationFullExampleToManyDTO;
import com.example.jpademo.services.DemoAssociationFullExampleToManyService;
import com.example.jpademo.vo.DemoAssociationFullExampleToManyQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToManyUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToManyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoAssociationFullExampleToMany")
public class DemoAssociationFullExampleToManyController {

    @Autowired
    private DemoAssociationFullExampleToManyService demoAssociationFullExampleToManyService;

    @PostMapping
    public String save(@Valid @RequestBody DemoAssociationFullExampleToManyVO vO) {
        return demoAssociationFullExampleToManyService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoAssociationFullExampleToManyService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoAssociationFullExampleToManyUpdateVO vO) {
        demoAssociationFullExampleToManyService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoAssociationFullExampleToManyDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoAssociationFullExampleToManyService.getById(id);
    }

    @GetMapping
    public Page<DemoAssociationFullExampleToManyDTO> query(@Valid DemoAssociationFullExampleToManyQueryVO vO) {
        return demoAssociationFullExampleToManyService.query(vO);
    }
}
