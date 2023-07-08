package com.example.jpademo.services;

import com.example.jpademo.dto.DemoAssociationFullExampleToManyDTO;
import com.example.jpademo.entity.DemoAssociationFullExampleToMany;
import com.example.jpademo.repository.DemoAssociationFullExampleToManyRepository;
import com.example.jpademo.vo.DemoAssociationFullExampleToManyQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToManyUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToManyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoAssociationFullExampleToManyService {

    @Autowired
    private DemoAssociationFullExampleToManyRepository demoAssociationFullExampleToManyRepository;

    public Long save(DemoAssociationFullExampleToManyVO vO) {
        DemoAssociationFullExampleToMany bean = new DemoAssociationFullExampleToMany();
        BeanUtils.copyProperties(vO, bean);
        bean = demoAssociationFullExampleToManyRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoAssociationFullExampleToManyRepository.deleteById(id);
    }

    public void update(Long id, DemoAssociationFullExampleToManyUpdateVO vO) {
        DemoAssociationFullExampleToMany bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoAssociationFullExampleToManyRepository.save(bean);
    }

    public DemoAssociationFullExampleToManyDTO getById(Long id) {
        DemoAssociationFullExampleToMany original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoAssociationFullExampleToManyDTO> query(DemoAssociationFullExampleToManyQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoAssociationFullExampleToManyDTO toDTO(DemoAssociationFullExampleToMany original) {
        DemoAssociationFullExampleToManyDTO bean = new DemoAssociationFullExampleToManyDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoAssociationFullExampleToMany requireOne(Long id) {
        return demoAssociationFullExampleToManyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
