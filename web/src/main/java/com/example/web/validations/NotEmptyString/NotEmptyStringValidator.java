package com.example.web.validations.NotEmptyString;

import com.example.web.validations.small.Small;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Jeanne 2023/6/22
 **/
public class NotEmptyStringValidator implements ConstraintValidator<Small, String> {

    @Override
    public void initialize(Small constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value);
    }
}
