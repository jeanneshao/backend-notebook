package com.example.transaction.controller;

import com.example.transaction.entity.DemoAsset;
import com.example.transaction.service.DemoAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jeanne 2023/7/2
 **/
@RestController
@RequestMapping("asset")
public class DemoAssetController {
    @Autowired
    DemoAssetService demoAssetService;

    @GetMapping(":all")
    public List<DemoAsset> selectAll() {
        return demoAssetService.selectAll();
    }

    @GetMapping("{id}")
    public DemoAsset getById(@PathVariable("id") Long id) {
        return demoAssetService.getById(id);
    }

    @PostMapping
    public List<DemoAsset> save(@RequestBody List<DemoAsset> demoAssetList) {
        List<DemoAsset> saved = demoAssetService.save(demoAssetList);
        return saved;
    }

    @PostMapping(":batch")
    public DemoAsset save(@RequestBody DemoAsset demoAssetList) {
        DemoAsset saved = demoAssetService.save(demoAssetList);
        return saved;
    }

    @DeleteMapping("{ids}:batch")
    public void delete(@PathVariable("ids") String ids) {
        List<Long> idList =  Arrays.asList(ids.split(",")).stream().map(Long::valueOf).collect(Collectors.toList());;
        demoAssetService.delete(idList);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Long id) {
        demoAssetService.delete(id);
    }


}
