package com.jeanne.lowcode.web.controller;

import com.jeanne.lowcode.web.vo.JsonBodyDemo;
import com.jeanne.lowcode.web.vo.UserScheduleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.PushBuilder;
import javax.validation.Valid;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Jeanne 2023/6/19
 **/
@Controller
@RequestMapping("/paramter")
@Slf4j
public class ParameterDemoController {

    @GetMapping("/request")
    public void testWebRequest(WebRequest webRequest,
                               NativeWebRequest nativeWebRequest,
                               ServletRequest servletRequest
    ) {
        log.info("testWebRequest,{},{},{}", webRequest, nativeWebRequest, servletRequest);

    }

    @GetMapping("/httpSession")
    public void testWebRequest(HttpSession httpSession) {
        log.info("testWebRequest,{}", httpSession);
    }

    @GetMapping("/PushBuilder")
    public void testWebRequest(PushBuilder pushBuilder) {
        log.info("testWebRequest,{}", pushBuilder);
    }

    @GetMapping("/locale")
    public void testWebRequest(Principal principal, HttpMethod httpMethod, Locale locale, TimeZone timeZone, ZoneId zoneId) {
        log.info("testWebRequest,{}", principal, httpMethod, locale, timeZone, zoneId);
    }

    @GetMapping("/readerWriter")
    public void testWebRequest(Reader reader, Writer writer) {
        int read = 0;
        try {
            read = reader.read();
        } catch (IOException e) {
            log.error("read error", e);
        }
        log.info("testWebRequest{}", read);
        try {
            writer.write("hello writer");
        } catch (IOException e) {
            log.error("write error", e);
        }
    }

    @GetMapping("/HttpEntity")
    @ResponseBody
    public void testWebRequest(
            WebRequest webRequest,
            HttpEntity<String> httpEntity
            , @RequestAttribute("org.springframework.web.util.UrlPathHelper.PATH") String path
            , @RequestAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT") ApplicationContext context
//                               ,@RequestAttribute("name") String name
    ) {
        log.info("testWebRequest,{}", httpEntity);
    }

    @GetMapping("/requestPart")
    @ResponseBody
    public String testWebRequest(
            HttpEntity<String> httpEntity,
            @RequestHeader("Content-Type") String contentType,
            @RequestPart("file") MultipartFile file,
            @RequestParam("stringFile") MultipartFile stringFile,
            @RequestParam String requestParam,
            @RequestPart("jsonBody") JsonBodyDemo jsonBodyDemo//,

//                                 @RequestBody() JsonBodyDemo jsonBodyDemo2
    ) {
        log.info("testWebRequest,{}", file, stringFile, requestParam);
        return "hello requestPart";
    }

    @GetMapping("/requestPart/{ppp}")
    @ResponseBody
    public String testWebRequest(
            @PathVariable("ppp") String pathParam
            , @RequestParam("name") String requestParam
            , @RequestHeader("Content-Type") String contentType
//            , @RequestParam("jsonBody") JsonBodyDemo jsonBodyDemo//
            , @RequestBody JsonBodyDemo jsonBodyDemo2

    ) {
        return "lalala";
    }

    @PostMapping("/modalMap/{ppp}")
    @ResponseBody
    public String testModalMap(
            HttpEntity<String> httpEntity,
            Map map
            , Model model
            , ModelMap modelMap

    ) {
        return "lalala";
    }

    @PostMapping("/validation/{ppp}")
    @ResponseBody
    public String useValidtion(@Valid @RequestBody UserScheduleVo userScheduleVo,
                               Errors errors,
                               BindingResult bindingResult) {

        System.out.println(bindingResult);
        return bindingResult.toString();
    }

    @GetMapping("/responsebody}")
    @ResponseBody
    public String responsebody() {
        return "222";
    }
    //HttpEntity<B>, ResponseEntity<B>

    @GetMapping("/httpEntity}")
    public HttpEntity httpEntity() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");//设置头信息
        return new HttpEntity<String>("Helloworld", responseHeaders);
    }

    @GetMapping("/responseEntity}")
    public ResponseEntity responseEntity() {
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserScheduleVo());
    }


}
