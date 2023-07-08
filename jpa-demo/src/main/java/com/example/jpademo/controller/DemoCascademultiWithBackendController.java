package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoCascademultiWithBackendDTO;
import com.example.jpademo.services.DemoCascademultiWithBackendService;
import com.example.jpademo.vo.DemoCascademultiWithBackendQueryVO;
import com.example.jpademo.vo.DemoCascademultiWithBackendUpdateVO;
import com.example.jpademo.vo.DemoCascademultiWithBackendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoCascademultiWithBackend")
public class DemoCascademultiWithBackendController {

    @Autowired
    private DemoCascademultiWithBackendService demoCascademultiWithBackendService;

    @PostMapping
    public String save(@Valid @RequestBody DemoCascademultiWithBackendVO vO) {
        return demoCascademultiWithBackendService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoCascademultiWithBackendService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoCascademultiWithBackendUpdateVO vO) {
        demoCascademultiWithBackendService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoCascademultiWithBackendDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoCascademultiWithBackendService.getById(id);
    }

    @GetMapping
    public Page<DemoCascademultiWithBackendDTO> query(@Valid DemoCascademultiWithBackendQueryVO vO) {
        return demoCascademultiWithBackendService.query(vO);
    }
}
