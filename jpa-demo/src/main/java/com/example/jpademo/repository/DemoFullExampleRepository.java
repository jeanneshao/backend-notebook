package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoFullExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoFullExampleRepository extends JpaRepository<DemoFullExample, Long>, JpaSpecificationExecutor<DemoFullExample> {

}