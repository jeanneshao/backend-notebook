package com.jeanne.lowcode.searchservice.aspect.permission;

import java.lang.annotation.*;

/**
 * @author Jeanne 2023/5/29
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnnotation {
}
