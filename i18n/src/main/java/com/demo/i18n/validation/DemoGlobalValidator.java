package com.demo.i18n.validation;

import com.demo.i18n.vo.ValidationVo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Jeanne 2023/6/24
 **/
public class DemoGlobalValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ValidationVo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationVo validationVo = (ValidationVo) target;
        ValidationUtils.rejectIfEmpty(errors, "defaultMessage", "defaultMessage.required");

    }
}
