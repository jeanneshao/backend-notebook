package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoAssociationFullExampleToCascadeDTO;
import com.example.jpademo.services.DemoAssociationFullExampleToCascadeService;
import com.example.jpademo.vo.DemoAssociationFullExampleToCascadeQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCascadeUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCascadeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoAssociationFullExampleToCascade")
public class DemoAssociationFullExampleToCascadeController {

    @Autowired
    private DemoAssociationFullExampleToCascadeService demoAssociationFullExampleToCascadeService;

    @PostMapping
    public String save(@Valid @RequestBody DemoAssociationFullExampleToCascadeVO vO) {
        return demoAssociationFullExampleToCascadeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoAssociationFullExampleToCascadeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoAssociationFullExampleToCascadeUpdateVO vO) {
        demoAssociationFullExampleToCascadeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoAssociationFullExampleToCascadeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoAssociationFullExampleToCascadeService.getById(id);
    }

    @GetMapping
    public Page<DemoAssociationFullExampleToCascadeDTO> query(@Valid DemoAssociationFullExampleToCascadeQueryVO vO) {
        return demoAssociationFullExampleToCascadeService.query(vO);
    }
}
