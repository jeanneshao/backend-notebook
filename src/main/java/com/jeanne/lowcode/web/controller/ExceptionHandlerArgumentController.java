package com.jeanne.lowcode.web.controller;

import com.jeanne.lowcode.web.service.ExceptionStimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.CodecException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.security.Principal;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jeanne 2023/6/23
 **/
@Controller
@RequestMapping("exception/argument")
public class ExceptionHandlerArgumentController {
    @Autowired
    ExceptionStimulationService exceptionStimulationService;

    @GetMapping
    @ResponseBody
    public String stimulateNestException() throws Exception {
        exceptionStimulationService.throwCodecException();
        return "success";

    }


//    @ExceptionHandler({CodecException.class})
//    public ResponseEntity<String> handleCodecException(
//            HandlerMethod handlerMethod,
//            ServletRequest servletRequest,
//            ServletResponse servletResponse,
//            HttpSession httpSession,
//            Principal principal,
//            HttpMethod httpMethod,
//            Locale locale,
//            ZoneId zoneId,
////            OutputStream outputStream,
////            Writer writer,
////            Map map,
////            Model model,
////            ModelMap modelMap,
////            RedirectAttributes redirectAttributes,
////            @SessionAttribute(required = false) String jSessionId,
////            @RequestAttribute(required = false) Long id,
//            CodecException ex
//    ) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FileNotFoundException: " + ex.getMessage());
//    }



}
