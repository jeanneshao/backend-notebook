package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoOneToManyExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoOneToManyExampleRepository extends JpaRepository<DemoOneToManyExample, Long>, JpaSpecificationExecutor<DemoOneToManyExample> {

}