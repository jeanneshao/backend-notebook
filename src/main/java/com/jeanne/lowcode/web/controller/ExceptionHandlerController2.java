package com.jeanne.lowcode.web.controller;

import com.jeanne.lowcode.web.service.ExceptionStimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Jeanne 2023/6/23
 **/
@Controller
@RequestMapping("exception2")
public class ExceptionHandlerController2 {
    @Autowired
    ExceptionStimulationService exceptionStimulationService;

    @GetMapping("/nest/{type}")
    @ResponseBody
    public String stimulateNestException(@PathVariable Long type) throws Exception {
        if (type < 10) {
            exceptionStimulationService.nestException();
        } else if (type < 15) {
            exceptionStimulationService.nestException2();
        } else if (type < 20) {
            exceptionStimulationService.throwCodecException();
        }
        return "success";

    }

    @GetMapping("/io/{type}")
    @ResponseBody
    public String stimulteIOException(@PathVariable Long type) throws IOException {
        if (type < 10) {
            exceptionStimulationService.throwIOException();
        } else if (type < 15) {
            exceptionStimulationService.throwFileNotFoundException();
        } else if (type < 20) {
            exceptionStimulationService.throwCodecException();
        }
        return "success";

    }
}
