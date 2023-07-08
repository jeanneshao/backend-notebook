package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoAssociationFullExampleToEnumDTO;
import com.example.jpademo.services.DemoAssociationFullExampleToEnumService;
import com.example.jpademo.vo.DemoAssociationFullExampleToEnumQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToEnumUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToEnumVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoAssociationFullExampleToEnum")
public class DemoAssociationFullExampleToEnumController {

    @Autowired
    private DemoAssociationFullExampleToEnumService demoAssociationFullExampleToEnumService;

    @PostMapping
    public String save(@Valid @RequestBody DemoAssociationFullExampleToEnumVO vO) {
        return demoAssociationFullExampleToEnumService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoAssociationFullExampleToEnumService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoAssociationFullExampleToEnumUpdateVO vO) {
        demoAssociationFullExampleToEnumService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoAssociationFullExampleToEnumDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoAssociationFullExampleToEnumService.getById(id);
    }

    @GetMapping
    public Page<DemoAssociationFullExampleToEnumDTO> query(@Valid DemoAssociationFullExampleToEnumQueryVO vO) {
        return demoAssociationFullExampleToEnumService.query(vO);
    }
}
