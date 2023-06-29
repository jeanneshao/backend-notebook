package com.example.web.controller;

import com.example.web.vo.ModelAttributeDemoVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Jeanne 2023/6/22
 **/
@Controller
public class ModelAttributeDemoController {
    /**
     *  /accounts/type1
     *  /accounts/type2
     *  /accounts/type3
     */
    @GetMapping("/accounts/{type}")
    public void update(@Valid ModelAttributeDemoVo form, BindingResult result,
                         @ModelAttribute("type") ModelAttributeDemoVo vo,
                        ModelAttributeDemoVo demoVo,
                       @ModelAttribute("demoVo") ModelAttributeDemoVo voAttribute

    ) {
        System.out.println("");
    }
    @ModelAttribute
    public ModelAttributeDemoVo create(){
        return new ModelAttributeDemoVo();
    }
    @ModelAttribute()
    public ModelAttributeDemoVo populate(WebRequest webRequest,
                                         @PathVariable Optional<String> type, Model model ) {
        ModelAttributeDemoVo demoVo = ModelAttributeDemoVo.builder().id(22l).name("demo_" + type).build();
        type.ifPresentOrElse(
                typeInner -> {
                    switch (typeInner) {
                        case "type1":
                        case "type2":
                            demoVo.setType(typeInner);
                            break;
                        default:
                            demoVo.setType("default");
                    }
                },
                ()->{
                    demoVo.setType("default");
                }
        );
        model.addAttribute("demoVo",demoVo);
        return demoVo;
    }
}
