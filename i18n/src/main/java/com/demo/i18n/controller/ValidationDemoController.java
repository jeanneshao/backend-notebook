package com.demo.i18n.controller;

import com.demo.i18n.validation.NotEmptyString.NotEmptyString;
import com.demo.i18n.validation.small.Small;
import com.demo.i18n.vo.AxiosResponse;
import com.demo.i18n.vo.ValidationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Jeanne 2023/7/23
 **/
@RestController
@RequestMapping("/validation")
@Slf4j
@Validated
public class ValidationDemoController {

    @GetMapping("get/{id}")
    public String demoGet(@Small(6666666) @PathVariable("id") Long id,
                          @NotEmptyString @RequestParam("name") String requestParam
    ) {
        return "OK";
    }

    @DeleteMapping("del/{id}")
    public String demoDelete(@Small(6666666) @PathVariable("id") Long id,
                             @NotEmptyString @RequestParam("name") String requestParam
    ) {
        return "OK";
    }

    @PostMapping("/validatedCustom/{id}")
    public ResponseEntity<Object> useValidtionValidated(@Small(6666666) @PathVariable Long id,
                                                  @Validated @RequestBody ValidationVo validationVo,
                                                  BindingResult bindingResult) {

        log.info(String.valueOf(bindingResult));
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.size() > 0) {
            return AxiosResponse.constraintViolations(fieldErrors);
        }
        return AxiosResponse.returnSingleData(validationVo);
    }

}
