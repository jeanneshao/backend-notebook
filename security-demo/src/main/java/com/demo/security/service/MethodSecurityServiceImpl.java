package com.demo.security.service;

import com.demo.security.vo.DemoVO;
import org.springframework.stereotype.Service;

/**
 * @author Jeanne 2023/7/20
 **/
@Service
public class MethodSecurityServiceImpl implements MethodSecurityService {
    @Override
    public DemoVO read(Long id) {
        DemoVO demoVO = DemoVO.builder().id(555l).name("lalala").build();
        return demoVO;
    }

    @Override
    public DemoVO read2(Long id) {
        DemoVO demoVO = DemoVO.builder().id(555l).name("lalala").build();
        return demoVO;
    }

    @Override
    public DemoVO[] find() {
        return new DemoVO[0];
    }

    @Override
    public DemoVO post(DemoVO account) {
        DemoVO demoVO = DemoVO.builder().id(555l).name("lalala").build();
        return demoVO;
    }
}
