package com.example.jpademo.services;

import com.example.jpademo.dto.DemoCascademultiWithBackendDTO;
import com.example.jpademo.entity.DemoCascademultiWithBackend;
import com.example.jpademo.repository.DemoCascademultiWithBackendRepository;
import com.example.jpademo.vo.DemoCascademultiWithBackendQueryVO;
import com.example.jpademo.vo.DemoCascademultiWithBackendUpdateVO;
import com.example.jpademo.vo.DemoCascademultiWithBackendVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoCascademultiWithBackendService {

    @Autowired
    private DemoCascademultiWithBackendRepository demoCascademultiWithBackendRepository;

    public Long save(DemoCascademultiWithBackendVO vO) {
        DemoCascademultiWithBackend bean = new DemoCascademultiWithBackend();
        BeanUtils.copyProperties(vO, bean);
        bean = demoCascademultiWithBackendRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoCascademultiWithBackendRepository.deleteById(id);
    }

    public void update(Long id, DemoCascademultiWithBackendUpdateVO vO) {
        DemoCascademultiWithBackend bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoCascademultiWithBackendRepository.save(bean);
    }

    public DemoCascademultiWithBackendDTO getById(Long id) {
        DemoCascademultiWithBackend original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoCascademultiWithBackendDTO> query(DemoCascademultiWithBackendQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoCascademultiWithBackendDTO toDTO(DemoCascademultiWithBackend original) {
        DemoCascademultiWithBackendDTO bean = new DemoCascademultiWithBackendDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoCascademultiWithBackend requireOne(Long id) {
        return demoCascademultiWithBackendRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
