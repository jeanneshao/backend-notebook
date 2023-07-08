package com.example.jpademo.services;

import com.example.jpademo.dto.DemoCogWithBackendDTO;
import com.example.jpademo.entity.DemoCogWithBackend;
import com.example.jpademo.repository.DemoCogWithBackendRepository;
import com.example.jpademo.vo.DemoCogWithBackendQueryVO;
import com.example.jpademo.vo.DemoCogWithBackendUpdateVO;
import com.example.jpademo.vo.DemoCogWithBackendVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoCogWithBackendService {

    @Autowired
    private DemoCogWithBackendRepository demoCogWithBackendRepository;

    public Long save(DemoCogWithBackendVO vO) {
        DemoCogWithBackend bean = new DemoCogWithBackend();
        BeanUtils.copyProperties(vO, bean);
        bean = demoCogWithBackendRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoCogWithBackendRepository.deleteById(id);
    }

    public void update(Long id, DemoCogWithBackendUpdateVO vO) {
        DemoCogWithBackend bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoCogWithBackendRepository.save(bean);
    }

    public DemoCogWithBackendDTO getById(Long id) {
        DemoCogWithBackend original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoCogWithBackendDTO> query(DemoCogWithBackendQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoCogWithBackendDTO toDTO(DemoCogWithBackend original) {
        DemoCogWithBackendDTO bean = new DemoCogWithBackendDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoCogWithBackend requireOne(Long id) {
        return demoCogWithBackendRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
