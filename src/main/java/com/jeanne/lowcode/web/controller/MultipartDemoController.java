package com.jeanne.lowcode.web.controller;

import com.jeanne.lowcode.web.vo.JsonBodyDemo;
import com.jeanne.lowcode.web.vo.MultiPartVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Jeanne 2023/6/22
 **/
@Controller
@Slf4j
public class MultipartDemoController {

    @PostMapping("/uploadPart")
    public String handleFormUploadPart(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam("stringFile") Optional<Part> file,
                                       @RequestParam("files") Optional<List<Part>> files) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.get().getInputStream().readAllBytes();
            } catch (IOException e) {
                log.error("IOException", e);
            }
// store the bytes somewhere
            return "redirect:uploadSuccess";
        }
        return "redirect:uploadFailure";
    }

    @PostMapping("/upload")
    public String handleFormUpload(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam("stringFile") Optional<MultipartFile> file,
                                   @RequestParam("files") Optional<List<MultipartFile>> files) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.get().getBytes();
            } catch (IOException e) {
                log.error("IOException", e);
            }
// store the bytes somewhere
            return "redirect:uploadSuccess";
        }
        return "redirect:uploadFailure";
    }

    @PostMapping("/uploadVo")
    public String handleFormUpload(MultiPartVo multiPartVo,
                                   BindingResult errors) {

        return "redirect:uploadFailure";
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

}
