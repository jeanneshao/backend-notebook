package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoAssociationFullExampleToEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoAssociationFullExampleToEnumRepository extends JpaRepository<DemoAssociationFullExampleToEnum, Long>, JpaSpecificationExecutor<DemoAssociationFullExampleToEnum> {

}