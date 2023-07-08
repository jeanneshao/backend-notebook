package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoAssociationFullExampleToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoAssociationFullExampleToManyRepository extends JpaRepository<DemoAssociationFullExampleToMany, Long>, JpaSpecificationExecutor<DemoAssociationFullExampleToMany> {

}