package com.example.jpademo.services;

import com.example.jpademo.dto.DemoOneToManyExampleDTO;
import com.example.jpademo.entity.DemoOneToManyExample;
import com.example.jpademo.repository.DemoOneToManyExampleRepository;
import com.example.jpademo.vo.DemoOneToManyExampleQueryVO;
import com.example.jpademo.vo.DemoOneToManyExampleUpdateVO;
import com.example.jpademo.vo.DemoOneToManyExampleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoOneToManyExampleService {

    @Autowired
    private DemoOneToManyExampleRepository demoOneToManyExampleRepository;

    public Long save(DemoOneToManyExampleVO vO) {
        DemoOneToManyExample bean = new DemoOneToManyExample();
        BeanUtils.copyProperties(vO, bean);
        bean = demoOneToManyExampleRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoOneToManyExampleRepository.deleteById(id);
    }

    public void update(Long id, DemoOneToManyExampleUpdateVO vO) {
        DemoOneToManyExample bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoOneToManyExampleRepository.save(bean);
    }

    public DemoOneToManyExampleDTO getById(Long id) {
        DemoOneToManyExample original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoOneToManyExampleDTO> query(DemoOneToManyExampleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoOneToManyExampleDTO toDTO(DemoOneToManyExample original) {
        DemoOneToManyExampleDTO bean = new DemoOneToManyExampleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoOneToManyExample requireOne(Long id) {
        return demoOneToManyExampleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
