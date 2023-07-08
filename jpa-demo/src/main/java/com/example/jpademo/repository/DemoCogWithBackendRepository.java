package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoCogWithBackend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoCogWithBackendRepository extends JpaRepository<DemoCogWithBackend, Long>, JpaSpecificationExecutor<DemoCogWithBackend> {

}