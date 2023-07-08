package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoAssociationFullExampleToFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoAssociationFullExampleToFileRepository extends JpaRepository<DemoAssociationFullExampleToFile, Long>, JpaSpecificationExecutor<DemoAssociationFullExampleToFile> {

}