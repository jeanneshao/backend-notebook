package com.demo.i18n.validation.NotEmptyString;

import com.demo.i18n.validation.NotEmptyString.NotEmptyString;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Jeanne 2023/6/22
 **/
public class NotEmptyStringValidator implements ConstraintValidator<NotEmptyString, String> {

    @Override
    public void initialize(NotEmptyString constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value);
    }
}
