package com.demo.i18n.controlleradvice;

import com.demo.i18n.vo.AxiosResponse;
import com.demo.i18n.vo.ValidationError;
import org.springframework.core.annotation.Order;
import org.springframework.core.codec.CodecException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jeanne 2023/6/23
 **/
@ControllerAdvice
@Order(1)
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ExceptionAdvice.class);

    @Override
    public ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        log.error("<==============================ExceptionAdvice.handleExceptionInternal=========================>");
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(/*{FileSystemException.class, RemoteException.class}*/)
    public ResponseEntity<String> handleException(Exception ex) throws Throwable {
        log.error("ExceptionAdvice======>Exception: " , ex);
        return AxiosResponse.exception(ex);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<List<ValidationError>> handleConstraintViolationException(ConstraintViolationException ex) throws Throwable {
        log.error("ExceptionAdvice======>ConstraintViolationException: " + ex.getMessage());
        return AxiosResponse.constraintViolations(ex.getConstraintViolations());
    }


}
