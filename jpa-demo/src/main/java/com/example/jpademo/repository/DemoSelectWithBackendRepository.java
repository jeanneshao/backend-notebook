package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoSelectWithBackend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoSelectWithBackendRepository extends JpaRepository<DemoSelectWithBackend, Long>, JpaSpecificationExecutor<DemoSelectWithBackend> {

}