package com.example.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Jeanne 2023/6/19
 **/
@ResponseStatus(value=HttpStatus.SEE_OTHER,reason="I'm a custom exception")
public class ExceptionDemo extends Exception{

    @ResponseStatus(value=HttpStatus.SEE_OTHER,reason="I'm a custom exception")
    public void throwsDemoException(){

    }
}
