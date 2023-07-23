package com.example.web.controller;

import com.example.web.validations.NotEmptyString.NotEmptyString;
import com.example.web.validations.small.Small;
import com.example.web.vo.ValidationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author Jeanne 2023/7/23
 **/
@RestController
@RequestMapping("/validation")
@Validated
@Slf4j
public class ValidationDemoController {
    
    @GetMapping("demo1/{id}")
    public Errors demoGet(@NotEmptyString @Small(6666666) @PathVariable("id") String id,
                          @NotEmptyString @RequestParam("name") String requestParam
                          ,Errors errors){
        return errors;
    }
    
    @PostMapping("/validatedCustom/{id}")
    public String useValidtionValidated(@NotBlank @PathVariable String id,
                                        @Validated @RequestBody ValidationVo validationVo,
                                        Errors errors,
                                        BindingResult bindingResult) {

        log.info(String.valueOf(bindingResult));
        return bindingResult.toString();
    }

    @PostMapping("/validDefault/{id}")
    @ResponseBody
    public String useValidtion(@Valid @RequestBody ValidationVo validationVo) {

        return "";
    }

    @PostMapping("/validatedDefault/{id}")
    @ResponseBody
    public String useValidtionValidated(@NotBlank @PathVariable String id, @Validated @RequestBody ValidationVo validationVo) {

        return "";
    }
}
