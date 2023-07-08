package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoAssetRepository extends JpaRepository<DemoAsset, String>, JpaSpecificationExecutor<DemoAsset> {

}