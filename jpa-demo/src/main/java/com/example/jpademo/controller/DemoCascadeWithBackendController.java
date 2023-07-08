package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoCascadeWithBackendDTO;
import com.example.jpademo.services.DemoCascadeWithBackendService;
import com.example.jpademo.vo.DemoCascadeWithBackendQueryVO;
import com.example.jpademo.vo.DemoCascadeWithBackendUpdateVO;
import com.example.jpademo.vo.DemoCascadeWithBackendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoCascadeWithBackend")
public class DemoCascadeWithBackendController {

    @Autowired
    private DemoCascadeWithBackendService demoCascadeWithBackendService;

    @PostMapping
    public String save(@Valid @RequestBody DemoCascadeWithBackendVO vO) {
        return demoCascadeWithBackendService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoCascadeWithBackendService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoCascadeWithBackendUpdateVO vO) {
        demoCascadeWithBackendService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoCascadeWithBackendDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoCascadeWithBackendService.getById(id);
    }

    @GetMapping
    public Page<DemoCascadeWithBackendDTO> query(@Valid DemoCascadeWithBackendQueryVO vO) {
        return demoCascadeWithBackendService.query(vO);
    }
}
