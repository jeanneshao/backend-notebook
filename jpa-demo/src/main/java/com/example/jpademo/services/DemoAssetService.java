package com.example.jpademo.services;

import com.example.jpademo.dto.DemoAssetDTO;
import com.example.jpademo.entity.DemoAsset;
import com.example.jpademo.repository.DemoAssetRepository;
import com.example.jpademo.vo.DemoAssetQueryVO;
import com.example.jpademo.vo.DemoAssetUpdateVO;
import com.example.jpademo.vo.DemoAssetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoAssetService {

    @Autowired
    private DemoAssetRepository demoAssetRepository;

    public String save(DemoAssetVO vO) {
        DemoAsset bean = new DemoAsset();
        BeanUtils.copyProperties(vO, bean);
        bean = demoAssetRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        demoAssetRepository.deleteById(id);
    }

    public void update(String id, DemoAssetUpdateVO vO) {
        DemoAsset bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoAssetRepository.save(bean);
    }

    public DemoAssetDTO getById(String id) {
        DemoAsset original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoAssetDTO> query(DemoAssetQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoAssetDTO toDTO(DemoAsset original) {
        DemoAssetDTO bean = new DemoAssetDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoAsset requireOne(String id) {
        return demoAssetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
