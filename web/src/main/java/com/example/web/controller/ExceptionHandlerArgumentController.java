package com.example.web.controller;

import com.example.web.service.ExceptionStimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
