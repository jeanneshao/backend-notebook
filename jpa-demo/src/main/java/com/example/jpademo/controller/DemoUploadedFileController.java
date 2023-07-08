package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoUploadedFileDTO;
import com.example.jpademo.services.DemoUploadedFileService;
import com.example.jpademo.vo.DemoUploadedFileQueryVO;
import com.example.jpademo.vo.DemoUploadedFileUpdateVO;
import com.example.jpademo.vo.DemoUploadedFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoUploadedFile")
public class DemoUploadedFileController {

    @Autowired
    private DemoUploadedFileService demoUploadedFileService;

    @PostMapping
    public String save(@Valid @RequestBody DemoUploadedFileVO vO) {
        return demoUploadedFileService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoUploadedFileService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoUploadedFileUpdateVO vO) {
        demoUploadedFileService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoUploadedFileDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoUploadedFileService.getById(id);
    }

    @GetMapping
    public Page<DemoUploadedFileDTO> query(@Valid DemoUploadedFileQueryVO vO) {
        return demoUploadedFileService.query(vO);
    }
}
