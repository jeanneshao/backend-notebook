package com.demo.i18n.validation.small;

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
@Constraint(validatedBy = { SmallValidator.class})
public @interface Small {
    String message() default "个性化Small校验";
    long value() default 100;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
