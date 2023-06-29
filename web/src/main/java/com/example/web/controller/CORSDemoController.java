package com.example.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeanne 2023/6/24
 **/
@RestController
@RequestMapping("cors")
public class CORSDemoController {

    @GetMapping
    public String empty() {
        return "cors cannot reach me~~";
    }

    @GetMapping("allowAll")
    @CrossOrigin
    public String annotated() {
        return "annotated~~";
    }

    @GetMapping("origins")
    @CrossOrigin(maxAge = 30, origins = {"http://localhost:63343"}, originPatterns = {"10*"})
    public String origins() {
        return "annotated origins~~";
    }

    @GetMapping("origins2")
    @CrossOrigin(maxAge = 30, origins = {"http://localhost:8888"}, originPatterns = {"10*"})
    public String origins2() {
        return "annotated origins~~";
    }

    @GetMapping("originPatterns")
    @CrossOrigin(maxAge = 30,
            originPatterns = {"http://local*"})
    public String originPatterns() {
        return "annotated originPatterns~~";
    }

    @GetMapping("originPatterns2")
    @CrossOrigin(maxAge = 30,
            originPatterns = {"https://local*"})
    public String originPatterns2() {
        return "annotated originPatterns~~";
    }


}
