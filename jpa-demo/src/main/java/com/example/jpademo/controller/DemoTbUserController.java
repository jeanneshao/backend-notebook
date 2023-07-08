package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoTbUserDTO;
import com.example.jpademo.services.DemoTbUserService;
import com.example.jpademo.vo.DemoTbUserQueryVO;
import com.example.jpademo.vo.DemoTbUserUpdateVO;
import com.example.jpademo.vo.DemoTbUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "")
@Validated
@RestController
@RequestMapping("/demoTbUser")
public class DemoTbUserController {

    @Autowired
    private DemoTbUserService demoTbUserService;

    @PostMapping
    @ApiOperation("保存 ")
    public String save(@Valid @RequestBody DemoTbUserVO vO) {
        return demoTbUserService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        demoTbUserService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("更新 ")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody DemoTbUserUpdateVO vO) {
        demoTbUserService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID获取 ")
    public DemoTbUserDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return demoTbUserService.getById(id);
    }

    @GetMapping
    @ApiOperation("自定义查询 ")
    public Page<DemoTbUserDTO> query(@Valid DemoTbUserQueryVO vO) {
        return demoTbUserService.query(vO);
    }
}
