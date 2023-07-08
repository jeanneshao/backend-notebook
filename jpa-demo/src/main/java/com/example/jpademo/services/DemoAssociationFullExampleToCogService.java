package com.example.jpademo.services;

import com.example.jpademo.dto.DemoAssociationFullExampleToCogDTO;
import com.example.jpademo.entity.DemoAssociationFullExampleToCog;
import com.example.jpademo.repository.DemoAssociationFullExampleToCogRepository;
import com.example.jpademo.vo.DemoAssociationFullExampleToCogQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCogUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCogVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoAssociationFullExampleToCogService {

    @Autowired
    private DemoAssociationFullExampleToCogRepository demoAssociationFullExampleToCogRepository;

    public Long save(DemoAssociationFullExampleToCogVO vO) {
        DemoAssociationFullExampleToCog bean = new DemoAssociationFullExampleToCog();
        BeanUtils.copyProperties(vO, bean);
        bean = demoAssociationFullExampleToCogRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoAssociationFullExampleToCogRepository.deleteById(id);
    }

    public void update(Long id, DemoAssociationFullExampleToCogUpdateVO vO) {
        DemoAssociationFullExampleToCog bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoAssociationFullExampleToCogRepository.save(bean);
    }

    public DemoAssociationFullExampleToCogDTO getById(Long id) {
        DemoAssociationFullExampleToCog original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoAssociationFullExampleToCogDTO> query(DemoAssociationFullExampleToCogQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoAssociationFullExampleToCogDTO toDTO(DemoAssociationFullExampleToCog original) {
        DemoAssociationFullExampleToCogDTO bean = new DemoAssociationFullExampleToCogDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoAssociationFullExampleToCog requireOne(Long id) {
        return demoAssociationFullExampleToCogRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
