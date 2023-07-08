package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoCogWithBackendDTO;
import com.example.jpademo.services.DemoCogWithBackendService;
import com.example.jpademo.vo.DemoCogWithBackendQueryVO;
import com.example.jpademo.vo.DemoCogWithBackendUpdateVO;
import com.example.jpademo.vo.DemoCogWithBackendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoCogWithBackend")
public class DemoCogWithBackendController {

    @Autowired
    private DemoCogWithBackendService demoCogWithBackendService;

    @PostMapping
    public String save(@Valid @RequestBody DemoCogWithBackendVO vO) {
        return demoCogWithBackendService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoCogWithBackendService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoCogWithBackendUpdateVO vO) {
        demoCogWithBackendService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoCogWithBackendDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoCogWithBackendService.getById(id);
    }

    @GetMapping
    public Page<DemoCogWithBackendDTO> query(@Valid DemoCogWithBackendQueryVO vO) {
        return demoCogWithBackendService.query(vO);
    }
}
