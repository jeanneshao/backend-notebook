package com.example.jpademo.services;

import com.example.jpademo.dto.DemoFullExampleDTO;
import com.example.jpademo.entity.DemoFullExample;
import com.example.jpademo.repository.DemoFullExampleRepository;
import com.example.jpademo.vo.DemoFullExampleQueryVO;
import com.example.jpademo.vo.DemoFullExampleUpdateVO;
import com.example.jpademo.vo.DemoFullExampleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoFullExampleService {

    @Autowired
    private DemoFullExampleRepository demoFullExampleRepository;

    public Long save(DemoFullExampleVO vO) {
        DemoFullExample bean = new DemoFullExample();
        BeanUtils.copyProperties(vO, bean);
        bean = demoFullExampleRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoFullExampleRepository.deleteById(id);
    }

    public void update(Long id, DemoFullExampleUpdateVO vO) {
        DemoFullExample bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoFullExampleRepository.save(bean);
    }

    public DemoFullExampleDTO getById(Long id) {
        DemoFullExample original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoFullExampleDTO> query(DemoFullExampleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoFullExampleDTO toDTO(DemoFullExample original) {
        DemoFullExampleDTO bean = new DemoFullExampleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoFullExample requireOne(Long id) {
        return demoFullExampleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
