package com.example.jpademo.controller;

import com.example.jpademo.dto.DemoCustomerDTO;
import com.example.jpademo.services.DemoCustomerService;
import com.example.jpademo.vo.DemoCustomerQueryVO;
import com.example.jpademo.vo.DemoCustomerUpdateVO;
import com.example.jpademo.vo.DemoCustomerVO;
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
@RequestMapping("/demoCustomer")
public class DemoCustomerController {

    @Autowired
    private DemoCustomerService demoCustomerService;

    @PostMapping
    @ApiOperation("保存 ")
    public String save(@Valid @RequestBody DemoCustomerVO vO) {
        return demoCustomerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除 ")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        demoCustomerService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("更新 ")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody DemoCustomerUpdateVO vO) {
        demoCustomerService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID获取 ")
    public DemoCustomerDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return demoCustomerService.getById(id);
    }

    @GetMapping
    @ApiOperation("自定义查询 ")
    public Page<DemoCustomerDTO> query(@Valid DemoCustomerQueryVO vO) {
        return demoCustomerService.query(vO);
    }
}
