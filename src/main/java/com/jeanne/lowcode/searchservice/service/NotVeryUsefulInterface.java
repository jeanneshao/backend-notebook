package com.jeanne.lowcode.searchservice.service;

import com.jeanne.lowcode.searchservice.aspect.permission.PermissionAnnotation;

/**
 * @author Jeanne 2023/6/1
 **/
public interface NotVeryUsefulInterface {
    String transfer();
    String transfer(Integer count);
    void within();
    void thisDemo();

    void transfer(PermissionService permissionService);

    void transfer(Object annotated);
}
