package com.example.web.validations.small;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Jeanne 2023/6/22
 **/
public class SmallValidator implements ConstraintValidator<Small, Long> {

    Long limit;
    @Override
    public void initialize(Small constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        limit = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value < limit;
    }
}
