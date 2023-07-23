package com.demo.i18n.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Path;

/**
 * @author Jeanne 2023/7/24
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {
    private String propertyPath;
    private Object invalidValue;
    private String message;
}
