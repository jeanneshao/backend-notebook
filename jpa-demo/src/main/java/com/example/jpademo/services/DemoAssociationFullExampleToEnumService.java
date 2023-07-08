package com.example.jpademo.services;

import com.example.jpademo.dto.DemoAssociationFullExampleToEnumDTO;
import com.example.jpademo.entity.DemoAssociationFullExampleToEnum;
import com.example.jpademo.repository.DemoAssociationFullExampleToEnumRepository;
import com.example.jpademo.vo.DemoAssociationFullExampleToEnumQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToEnumUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToEnumVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoAssociationFullExampleToEnumService {

    @Autowired
    private DemoAssociationFullExampleToEnumRepository demoAssociationFullExampleToEnumRepository;

    public Long save(DemoAssociationFullExampleToEnumVO vO) {
        DemoAssociationFullExampleToEnum bean = new DemoAssociationFullExampleToEnum();
        BeanUtils.copyProperties(vO, bean);
        bean = demoAssociationFullExampleToEnumRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoAssociationFullExampleToEnumRepository.deleteById(id);
    }

    public void update(Long id, DemoAssociationFullExampleToEnumUpdateVO vO) {
        DemoAssociationFullExampleToEnum bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoAssociationFullExampleToEnumRepository.save(bean);
    }

    public DemoAssociationFullExampleToEnumDTO getById(Long id) {
        DemoAssociationFullExampleToEnum original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoAssociationFullExampleToEnumDTO> query(DemoAssociationFullExampleToEnumQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoAssociationFullExampleToEnumDTO toDTO(DemoAssociationFullExampleToEnum original) {
        DemoAssociationFullExampleToEnumDTO bean = new DemoAssociationFullExampleToEnumDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoAssociationFullExampleToEnum requireOne(Long id) {
        return demoAssociationFullExampleToEnumRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
