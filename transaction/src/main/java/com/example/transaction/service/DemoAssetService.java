package com.example.transaction.service;


import com.example.transaction.entity.DemoAsset;
import com.example.transaction.repository.DemoAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jeanne 2023/7/2
 **/
@Service
public class DemoAssetService {
    @Autowired
    DemoAssetRepository demoAssetRepository;

    public List<DemoAsset> selectAll() {
        return demoAssetRepository.findAll();
    }

    public DemoAsset getById(Long id) {
        return demoAssetRepository.getById(id);
    }

    public List<DemoAsset> save(List<DemoAsset> demoAssetList) {
        List<DemoAsset> saved = demoAssetRepository.saveAll(demoAssetList);
        return saved;
    }

    public DemoAsset save(DemoAsset demoAsset) {
        DemoAsset saved = demoAssetRepository.save(demoAsset);
        return saved;
    }

    public void delete(List<Long> ids) {
        demoAssetRepository.deleteAllById(ids);
    }

    public void delete(Long id) {
        demoAssetRepository.deleteById(id);
    }




}
