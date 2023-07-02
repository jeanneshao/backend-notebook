package com.example.transaction.repository;

import com.example.transaction.entity.DemoAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jeanne 2023/4/12
 **/
@Repository
public interface DemoAssetRepository extends JpaRepository<DemoAsset, Long> {

}
