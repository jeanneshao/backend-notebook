package com.demo.i18n.validation.NotEmptyString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Jeanne 2023/6/22
 **/
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { NotEmptyStringValidator.class})
public @interface NotEmptyString {
    String message() default "不能为空或者为NUll";
    long value() default 100;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
