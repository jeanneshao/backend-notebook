package com.example.jpademo.services;

import com.example.jpademo.dto.DemoAssociationFullExampleToFileDTO;
import com.example.jpademo.entity.DemoAssociationFullExampleToFile;
import com.example.jpademo.repository.DemoAssociationFullExampleToFileRepository;
import com.example.jpademo.vo.DemoAssociationFullExampleToFileQueryVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToFileUpdateVO;
import com.example.jpademo.vo.DemoAssociationFullExampleToFileVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoAssociationFullExampleToFileService {

    @Autowired
    private DemoAssociationFullExampleToFileRepository demoAssociationFullExampleToFileRepository;

    public Long save(DemoAssociationFullExampleToFileVO vO) {
        DemoAssociationFullExampleToFile bean = new DemoAssociationFullExampleToFile();
        BeanUtils.copyProperties(vO, bean);
        bean = demoAssociationFullExampleToFileRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoAssociationFullExampleToFileRepository.deleteById(id);
    }

    public void update(Long id, DemoAssociationFullExampleToFileUpdateVO vO) {
        DemoAssociationFullExampleToFile bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoAssociationFullExampleToFileRepository.save(bean);
    }

    public DemoAssociationFullExampleToFileDTO getById(Long id) {
        DemoAssociationFullExampleToFile original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoAssociationFullExampleToFileDTO> query(DemoAssociationFullExampleToFileQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoAssociationFullExampleToFileDTO toDTO(DemoAssociationFullExampleToFile original) {
        DemoAssociationFullExampleToFileDTO bean = new DemoAssociationFullExampleToFileDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoAssociationFullExampleToFile requireOne(Long id) {
        return demoAssociationFullExampleToFileRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
