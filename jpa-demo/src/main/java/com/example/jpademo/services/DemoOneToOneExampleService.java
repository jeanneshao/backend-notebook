package com.example.jpademo.services;

import com.example.jpademo.dto.DemoOneToOneExampleDTO;
import com.example.jpademo.entity.DemoOneToOneExample;
import com.example.jpademo.repository.DemoOneToOneExampleRepository;
import com.example.jpademo.vo.DemoOneToOneExampleQueryVO;
import com.example.jpademo.vo.DemoOneToOneExampleUpdateVO;
import com.example.jpademo.vo.DemoOneToOneExampleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoOneToOneExampleService {

    @Autowired
    private DemoOneToOneExampleRepository demoOneToOneExampleRepository;

    public Long save(DemoOneToOneExampleVO vO) {
        DemoOneToOneExample bean = new DemoOneToOneExample();
        BeanUtils.copyProperties(vO, bean);
        bean = demoOneToOneExampleRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoOneToOneExampleRepository.deleteById(id);
    }

    public void update(Long id, DemoOneToOneExampleUpdateVO vO) {
        DemoOneToOneExample bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoOneToOneExampleRepository.save(bean);
    }

    public DemoOneToOneExampleDTO getById(Long id) {
        DemoOneToOneExample original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoOneToOneExampleDTO> query(DemoOneToOneExampleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoOneToOneExampleDTO toDTO(DemoOneToOneExample original) {
        DemoOneToOneExampleDTO bean = new DemoOneToOneExampleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoOneToOneExample requireOne(Long id) {
        return demoOneToOneExampleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
