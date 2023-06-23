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
@RequestMapping("exception")
public class ExceptionHandlerController {
    @Autowired
    ExceptionStimulationService exceptionStimulationService;

    @ExceptionHandler(/*{FileSystemException.class, RemoteException.class}*/)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception: " + ex.getMessage());
    }

    @ExceptionHandler(/*{FileSystemException.class, RemoteException.class}*/)
    public ResponseEntity<String> handleIOException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IOException: " + ex.getMessage());
    }

    @ExceptionHandler({FileNotFoundException.class})
    public ResponseEntity<String> handleFileNotFoundException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FileNotFoundException: " + ex.getMessage());
    }

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
