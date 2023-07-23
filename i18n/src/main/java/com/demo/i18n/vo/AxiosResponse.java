package com.demo.i18n.vo;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jeanne 2023/7/24
 **/
@Data
@Builder
public class AxiosResponse {

    public static ResponseEntity exception(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
    }

    public static ResponseEntity constraintViolations(Set<ConstraintViolation<?>> constraintViolationSet) {
        List<ValidationError> validationErrors = constraintViolationSet.stream().map(constraintViolation ->
                ValidationError.builder()
                        .propertyPath(constraintViolation.getPropertyPath().toString())
                        .message(constraintViolation.getMessageTemplate())
                        .invalidValue(constraintViolation.getInvalidValue()).build()
        ).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
    }

    public static ResponseEntity constraintViolations(List<FieldError> fieldErrors) {
        List<ValidationError> validationErrors = fieldErrors.stream().map(constraintViolation ->
                ValidationError.builder()
                        .propertyPath(constraintViolation.getField())
                        .message(constraintViolation.getDefaultMessage())
                        .invalidValue(constraintViolation.getRejectedValue()).build()
        ).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
    }

    public static ResponseEntity returnSingleData(Object returnObject) {
        return ResponseEntity.status(HttpStatus.OK).body(returnObject);
    }

    public static ResponseEntity returnFullList(List returnList) {
        return ResponseEntity.status(HttpStatus.OK).body(returnList);
    }

    public static ResponseEntity pagedList(List returnList, PaginationVO pagination) {
        //把list和分页信息组织到一起，再返回...
        return ResponseEntity.status(HttpStatus.OK).body(returnList);
    }


}
