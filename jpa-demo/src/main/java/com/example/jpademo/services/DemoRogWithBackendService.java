package com.example.jpademo.services;

import com.example.jpademo.dto.DemoRogWithBackendDTO;
import com.example.jpademo.entity.DemoRogWithBackend;
import com.example.jpademo.repository.DemoRogWithBackendRepository;
import com.example.jpademo.vo.DemoRogWithBackendQueryVO;
import com.example.jpademo.vo.DemoRogWithBackendUpdateVO;
import com.example.jpademo.vo.DemoRogWithBackendVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoRogWithBackendService {

    @Autowired
    private DemoRogWithBackendRepository demoRogWithBackendRepository;

    public Long save(DemoRogWithBackendVO vO) {
        DemoRogWithBackend bean = new DemoRogWithBackend();
        BeanUtils.copyProperties(vO, bean);
        bean = demoRogWithBackendRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoRogWithBackendRepository.deleteById(id);
    }

    public void update(Long id, DemoRogWithBackendUpdateVO vO) {
        DemoRogWithBackend bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoRogWithBackendRepository.save(bean);
    }

    public DemoRogWithBackendDTO getById(Long id) {
        DemoRogWithBackend original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoRogWithBackendDTO> query(DemoRogWithBackendQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoRogWithBackendDTO toDTO(DemoRogWithBackend original) {
        DemoRogWithBackendDTO bean = new DemoRogWithBackendDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoRogWithBackend requireOne(Long id) {
        return demoRogWithBackendRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
