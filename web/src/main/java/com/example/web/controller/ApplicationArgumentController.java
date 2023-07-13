package com.example.web.controller;

import com.example.web.config.DemoProperties;
import com.example.web.service.ApplicationArgumentDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/7/12
 **/
@RestController()
@RequestMapping("/applicationArguments")
public class ApplicationArgumentController {
    @Autowired
    ApplicationArgumentDemoService applicationArgumentDemoService;
    @Autowired
    ApplicationArguments applicationArguments;
    @Autowired
    private Environment environment;
    @Autowired
    DemoProperties demoProperties;

    @GetMapping
    public String[] getApplicationArguments(){
        //-Dvm.option=demo -Dvm.option2=demo2
        String vmArgument = System.getProperty("vm.option");
        String vmArgument2 = System.getProperty("vm.option2");
        //environment.variable1=variable1;environment.variable2=variable2
        String property = environment.getProperty("environment.variable1");
        String property2 = environment.getProperty("environment.variable2");
        //--vm.argument="demo argument" --vm.argument2="demo argument2" aaa bbb
        applicationArgumentDemoService.printArguments();
        return applicationArguments.getSourceArgs();
    }

}
