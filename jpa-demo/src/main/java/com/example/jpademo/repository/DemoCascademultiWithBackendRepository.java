package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoCascademultiWithBackend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoCascademultiWithBackendRepository extends JpaRepository<DemoCascademultiWithBackend, Long>, JpaSpecificationExecutor<DemoCascademultiWithBackend> {

}