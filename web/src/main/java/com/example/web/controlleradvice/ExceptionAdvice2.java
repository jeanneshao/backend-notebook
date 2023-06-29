package com.example.web.controlleradvice;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Jeanne 2023/6/23
 **/
@ControllerAdvice
@Order(2)
public class ExceptionAdvice2 {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ExceptionAdvice2.class);
    @ExceptionHandler(/*{FileSystemException.class, RemoteException.class}*/)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error("ExceptionAdvice2======>Exception: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ExceptionAdvice2======>Exception: " + ex.getMessage());
    }

    @ExceptionHandler(/*{FileSystemException.class, RemoteException.class}*/)
    public ResponseEntity<String> handleIOException(IOException ex) {
        log.error("ExceptionAdvice2======>IOException: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ExceptionAdvice2======>IOException: " + ex.getMessage());
    }

    @ExceptionHandler({FileNotFoundException.class})
    public ResponseEntity<String> handleFileNotFoundException(IOException ex) {
        log.error("ExceptionAdvice2======>FileNotFoundException: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ExceptionAdvice2======>FileNotFoundException: " + ex.getMessage());
    }

}
