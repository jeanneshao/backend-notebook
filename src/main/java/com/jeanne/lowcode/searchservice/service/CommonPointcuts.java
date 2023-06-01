package com.jeanne.lowcode.searchservice.service;

import com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/5/29
 **/
@Service
public class CommonPointcuts {

    @PermissionAnnotation
    public String dataAccessOperation() {
        System.out.println("hello aop");
        return "Hello";
    }

    public String dataAccessOperation(int i) {
        System.out.println("hello aop111");
        return "Hello";
    }
   public String dataAccessOperation(int i,String name) {
        System.out.println("hello aop111");
        return "Hello";
    }

}
