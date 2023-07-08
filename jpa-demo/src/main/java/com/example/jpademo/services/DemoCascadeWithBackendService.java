package com.example.jpademo.services;

import com.example.jpademo.dto.DemoCascadeWithBackendDTO;
import com.example.jpademo.entity.DemoCascadeWithBackend;
import com.example.jpademo.repository.DemoCascadeWithBackendRepository;
import com.example.jpademo.vo.DemoCascadeWithBackendQueryVO;
import com.example.jpademo.vo.DemoCascadeWithBackendUpdateVO;
import com.example.jpademo.vo.DemoCascadeWithBackendVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoCascadeWithBackendService {

    @Autowired
    private DemoCascadeWithBackendRepository demoCascadeWithBackendRepository;

    public Long save(DemoCascadeWithBackendVO vO) {
        DemoCascadeWithBackend bean = new DemoCascadeWithBackend();
        BeanUtils.copyProperties(vO, bean);
        bean = demoCascadeWithBackendRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoCascadeWithBackendRepository.deleteById(id);
    }

    public void update(Long id, DemoCascadeWithBackendUpdateVO vO) {
        DemoCascadeWithBackend bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoCascadeWithBackendRepository.save(bean);
    }

    public DemoCascadeWithBackendDTO getById(Long id) {
        DemoCascadeWithBackend original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoCascadeWithBackendDTO> query(DemoCascadeWithBackendQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoCascadeWithBackendDTO toDTO(DemoCascadeWithBackend original) {
        DemoCascadeWithBackendDTO bean = new DemoCascadeWithBackendDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoCascadeWithBackend requireOne(Long id) {
        return demoCascadeWithBackendRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
