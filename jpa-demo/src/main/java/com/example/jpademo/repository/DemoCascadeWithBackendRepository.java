package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoCascadeWithBackend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoCascadeWithBackendRepository extends JpaRepository<DemoCascadeWithBackend, Long>, JpaSpecificationExecutor<DemoCascadeWithBackend> {

}