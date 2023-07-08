package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoAssociationFullExampleToFileDTO;
import com.example.jpademo.services.DemoAssociationFullExampleToFileService;
import com.example.jpademo.vo.DemoAssociationFullExampleToFileQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToFileUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoAssociationFullExampleToFile")
public class DemoAssociationFullExampleToFileController {

    @Autowired
    private DemoAssociationFullExampleToFileService demoAssociationFullExampleToFileService;

    @PostMapping
    public String save(@Valid @RequestBody DemoAssociationFullExampleToFileVO vO) {
        return demoAssociationFullExampleToFileService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoAssociationFullExampleToFileService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoAssociationFullExampleToFileUpdateVO vO) {
        demoAssociationFullExampleToFileService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoAssociationFullExampleToFileDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoAssociationFullExampleToFileService.getById(id);
    }

    @GetMapping
    public Page<DemoAssociationFullExampleToFileDTO> query(@Valid DemoAssociationFullExampleToFileQueryVO vO) {
        return demoAssociationFullExampleToFileService.query(vO);
    }
}
