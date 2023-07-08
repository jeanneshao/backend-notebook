package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoLobDemoDTO;
import com.example.jpademo.services.DemoLobDemoService;
import com.example.jpademo.vo.DemoLobDemoQueryVO;
import com.example.jpademo.vo.DemoLobDemoUpdateVO;
import com.example.jpademo.vo.DemoLobDemoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/demoLobDemo")
public class DemoLobDemoController {

    @Autowired
    private DemoLobDemoService demoLobDemoService;

    @PostMapping
    public String save(@Valid @RequestBody DemoLobDemoVO vO) {
        return demoLobDemoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        demoLobDemoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DemoLobDemoUpdateVO vO) {
        demoLobDemoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DemoLobDemoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return demoLobDemoService.getById(id);
    }

    @GetMapping
    public Page<DemoLobDemoDTO> query(@Valid DemoLobDemoQueryVO vO) {
        return demoLobDemoService.query(vO);
    }
}
