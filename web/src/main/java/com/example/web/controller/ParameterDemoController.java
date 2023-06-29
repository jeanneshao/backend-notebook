package com.example.web.controller;

import com.example.web.vo.JsonBodyDemo;
import com.example.web.vo.ValidationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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
import java.util.*;

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

    @PostMapping("/validCustom/{ppp}")
    @ResponseBody
    public String useValidtion(@Valid @RequestBody ValidationVo validationVo,
                               Errors errors,
                               BindingResult bindingResult) {

        System.out.println(bindingResult);
        return bindingResult.toString();
    }

    @PostMapping("/validatedCustom/{ppp}")
    @ResponseBody
    public String useValidtionValidated(@Validated @RequestBody ValidationVo validationVo,
                               Errors errors,
                               BindingResult bindingResult) {

        System.out.println(bindingResult);
        return bindingResult.toString();
    }

    @PostMapping("/validDefault/{ppp}")
    @ResponseBody
    public String useValidtion(@Valid @RequestBody ValidationVo validationVo) {

        return "";
    }

    @PostMapping("/validatedDefault/{ppp}")
    @ResponseBody
    public String useValidtionValidated(@Validated @RequestBody ValidationVo validationVo) {

        return "";
    }

    @GetMapping("/responsebody")
    @ResponseBody
    public String responsebody() {
        return "222";
    }
    //HttpEntity<B>, ResponseEntity<B>

    @GetMapping("/httpEntityOut")
    public HttpEntity httpEntity() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");//设置头信息
        return new HttpEntity<String>("Helloworld", responseHeaders);
    }

    @GetMapping("/responseEntity")
    public ResponseEntity responseEntity() {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ValidationVo());
    }

    @GetMapping("/reponseMap")
//    @ResponseBody
    public Map returnMap() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name", "lll2222");
        return stringStringHashMap;
    }


    @GetMapping("/reponseHeaders")
//    @ResponseBody
    public HttpHeaders returnHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("hello", Arrays.asList("world"));
        return httpHeaders;
    }

    // GET /pets/42;q=11;r=22
    @GetMapping("/pets/{petId}")
    public void findPet(@PathVariable String petId, @MatrixVariable String q, @MatrixVariable int r) {
        // petId == 42
        // q == 11
        System.out.println(q);
    }

    // GET /owners/42;q=11/pets/21;q=22
    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public void findPet(
            @MatrixVariable(name = "q", pathVar = "ownerId") int q1,
            @MatrixVariable(name = "q", pathVar = "petId") int q2) {
        System.out.println(q1);

// q1 == 11
// q2 == 22
    }

    // GET /owners/42;q=11;r=12/petsMultiValueMap/21;q=22;s=23
    @GetMapping("/owners/{ownerId}/petsMultiValueMap/{petId}")
    public void findPetMultiValueMap(
            @MatrixVariable MultiValueMap<String, String> matrixVars,
            @MatrixVariable(pathVar = "petId") MultiValueMap<String, String> petMatrixVars) {
        System.out.println(petMatrixVars);
        // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
        // petMatrixVars: ["q" : 22, "s" : 23]
    }

    // GET /requestParams?p=3&p=5&q=weeee&q=dde
    @PostMapping("/requestParams")
    public void requestParam(
            @RequestParam("p") int p,
            @RequestParam("p") int[] ps,
            @RequestParam("p") List pl,
            @RequestParam Map<String, String> pm,
            @RequestParam MultiValueMap<String, String> pmm) {
        System.out.println(p);
        // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
        // petMatrixVars: ["q" : 22, "s" : 23]
    }

    // GET /requestParams?p=3&p=5&q=weeee&q=dde
    @PostMapping("/getHeaders")
    public void getHeaders(
            @RequestHeader("accept-encoding") List<String> acceptedEncoding,
            @RequestHeader Map<String, String> headerMap
            , @RequestHeader MultiValueMap<String, String> headerMultiMap

            , @RequestHeader HttpHeaders headers
    ) {
        System.out.println("headers");
        // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
        // petMatrixVars: ["q" : 22, "s" : 23]
    }


}
