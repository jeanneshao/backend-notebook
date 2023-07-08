package com.example.jpademo.services;

import com.example.jpademo.dto.DemoLowcodeEnumDTO;
import com.example.jpademo.entity.DemoLowcodeEnum;
import com.example.jpademo.repository.DemoLowcodeEnumRepository;
import com.example.jpademo.vo.DemoLowcodeEnumQueryVO;
import com.example.jpademo.vo.DemoLowcodeEnumUpdateVO;
import com.example.jpademo.vo.DemoLowcodeEnumVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoLowcodeEnumService {

    @Autowired
    private DemoLowcodeEnumRepository demoLowcodeEnumRepository;

    public Long save(DemoLowcodeEnumVO vO) {
        DemoLowcodeEnum bean = new DemoLowcodeEnum();
        BeanUtils.copyProperties(vO, bean);
        bean = demoLowcodeEnumRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoLowcodeEnumRepository.deleteById(id);
    }

    public void update(Long id, DemoLowcodeEnumUpdateVO vO) {
        DemoLowcodeEnum bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoLowcodeEnumRepository.save(bean);
    }

    public DemoLowcodeEnumDTO getById(Long id) {
        DemoLowcodeEnum original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoLowcodeEnumDTO> query(DemoLowcodeEnumQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoLowcodeEnumDTO toDTO(DemoLowcodeEnum original) {
        DemoLowcodeEnumDTO bean = new DemoLowcodeEnumDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoLowcodeEnum requireOne(Long id) {
        return demoLowcodeEnumRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
