package com.example.transactionmybatisdemo.controller;

import com.asiainfo.lowcode.entity.FullExample;
import com.asiainfo.lowcode.service.FullExampleService;
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
@RequestMapping(path = "/fullExample")
public class FullExampleController extends BaseEntityController {
    @Autowired
    FullExampleService fullExampleService;

    @PostMapping
    public String save(@RequestBody FullExample fullExample){
        fullExampleService.saveOrUpdate(fullExample);
        return "Success";
    }

    @GetMapping(path="/{id}")
    public FullExample getById(@PathVariable Long id){
        FullExample fullExample = fullExampleService.getById(id);
        return fullExample;//fullExample;
    }


}
