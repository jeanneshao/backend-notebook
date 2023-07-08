package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoRogWithBackend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoRogWithBackendRepository extends JpaRepository<DemoRogWithBackend, Long>, JpaSpecificationExecutor<DemoRogWithBackend> {

}