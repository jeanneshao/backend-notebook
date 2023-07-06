package com.example.transactionmybatisdemo.controller;

import com.example.transactionmybatisdemo.entity.DemoAsset;
import com.example.transactionmybatisdemo.service.DemoAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * entry resource 前端控制器
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Controller
@RequestMapping(path = "/demoAsset")
public class DemoAssetController {
    @Autowired
    DemoAssetService demoAssetService;

    @PostMapping
    public String save(@RequestBody DemoAsset demoAsset){
        demoAssetService.saveOrUpdate(demoAsset);
        return "Success";
    }

    @GetMapping(path="/{id}")
    public DemoAsset getById(@PathVariable Long id){
        DemoAsset DemoAsset = demoAssetService.getById(id);
        return DemoAsset;//DemoAsset;
    }


}
