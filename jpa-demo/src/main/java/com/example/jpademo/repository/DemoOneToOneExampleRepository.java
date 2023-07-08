package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoOneToOneExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoOneToOneExampleRepository extends JpaRepository<DemoOneToOneExample, Long>, JpaSpecificationExecutor<DemoOneToOneExample> {

}