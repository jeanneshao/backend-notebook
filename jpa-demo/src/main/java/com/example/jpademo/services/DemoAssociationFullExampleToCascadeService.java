package com.example.jpademo.services;

import com.example.jpademo.dto.DemoAssociationFullExampleToCascadeDTO;
import com.example.jpademo.entity.DemoAssociationFullExampleToCascade;
import com.example.jpademo.repository.DemoAssociationFullExampleToCascadeRepository;
import com.example.jpademo.vo.DemoAssociationFullExampleToCascadeQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCascadeUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToCascadeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoAssociationFullExampleToCascadeService {

    @Autowired
    private DemoAssociationFullExampleToCascadeRepository demoAssociationFullExampleToCascadeRepository;

    public Long save(DemoAssociationFullExampleToCascadeVO vO) {
        DemoAssociationFullExampleToCascade bean = new DemoAssociationFullExampleToCascade();
        BeanUtils.copyProperties(vO, bean);
        bean = demoAssociationFullExampleToCascadeRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoAssociationFullExampleToCascadeRepository.deleteById(id);
    }

    public void update(Long id, DemoAssociationFullExampleToCascadeUpdateVO vO) {
        DemoAssociationFullExampleToCascade bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoAssociationFullExampleToCascadeRepository.save(bean);
    }

    public DemoAssociationFullExampleToCascadeDTO getById(Long id) {
        DemoAssociationFullExampleToCascade original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoAssociationFullExampleToCascadeDTO> query(DemoAssociationFullExampleToCascadeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoAssociationFullExampleToCascadeDTO toDTO(DemoAssociationFullExampleToCascade original) {
        DemoAssociationFullExampleToCascadeDTO bean = new DemoAssociationFullExampleToCascadeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoAssociationFullExampleToCascade requireOne(Long id) {
        return demoAssociationFullExampleToCascadeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
