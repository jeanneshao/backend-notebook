package com.demo.security.evaluators;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Jeanne 2023/7/18
 **/
@Component
public class DemoVoPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        String classSimpleName = targetDomainObject.getClass().getSimpleName();
//        return authentication.getAuthorities().stream().anyMatch((a)-> classSimpleName.equals(a));
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return authentication.getAuthorities().stream().anyMatch((a)-> targetType.equals(a));
    }
}
