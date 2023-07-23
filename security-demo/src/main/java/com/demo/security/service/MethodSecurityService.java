package com.demo.security.service;

import com.demo.security.vo.DemoVO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/7/20
 **/
public interface MethodSecurityService {
    @Secured("ROLE_ADMIN")
    public DemoVO read(Long id);
    @Secured("ROLE_READ") //根据权限决定
    public DemoVO read2(Long id);
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY") // 不登录也能访问
    public DemoVO[] find();
    @Secured("ROLE_TELLER")
    public DemoVO post(DemoVO account);
}
