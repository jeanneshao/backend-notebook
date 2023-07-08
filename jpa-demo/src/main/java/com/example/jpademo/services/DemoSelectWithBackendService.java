package com.example.jpademo.services;

import com.example.jpademo.dto.DemoSelectWithBackendDTO;
import com.example.jpademo.entity.DemoSelectWithBackend;
import com.example.jpademo.repository.DemoSelectWithBackendRepository;
import com.example.jpademo.vo.DemoSelectWithBackendQueryVO;
import com.example.jpademo.vo.DemoSelectWithBackendUpdateVO;
import com.example.jpademo.vo.DemoSelectWithBackendVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoSelectWithBackendService {

    @Autowired
    private DemoSelectWithBackendRepository demoSelectWithBackendRepository;

    public Long save(DemoSelectWithBackendVO vO) {
        DemoSelectWithBackend bean = new DemoSelectWithBackend();
        BeanUtils.copyProperties(vO, bean);
        bean = demoSelectWithBackendRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoSelectWithBackendRepository.deleteById(id);
    }

    public void update(Long id, DemoSelectWithBackendUpdateVO vO) {
        DemoSelectWithBackend bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoSelectWithBackendRepository.save(bean);
    }

    public DemoSelectWithBackendDTO getById(Long id) {
        DemoSelectWithBackend original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoSelectWithBackendDTO> query(DemoSelectWithBackendQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoSelectWithBackendDTO toDTO(DemoSelectWithBackend original) {
        DemoSelectWithBackendDTO bean = new DemoSelectWithBackendDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoSelectWithBackend requireOne(Long id) {
        return demoSelectWithBackendRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
