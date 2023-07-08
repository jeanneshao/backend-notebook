package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoAssociationFullExampleToCascade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoAssociationFullExampleToCascadeRepository extends JpaRepository<DemoAssociationFullExampleToCascade, Long>, JpaSpecificationExecutor<DemoAssociationFullExampleToCascade> {

}