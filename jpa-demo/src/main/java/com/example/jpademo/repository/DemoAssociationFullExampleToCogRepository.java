package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoAssociationFullExampleToCog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoAssociationFullExampleToCogRepository extends JpaRepository<DemoAssociationFullExampleToCog, Long>, JpaSpecificationExecutor<DemoAssociationFullExampleToCog> {

}