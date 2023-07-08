package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoLobDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoLobDemoRepository extends JpaRepository<DemoLobDemo, Long>, JpaSpecificationExecutor<DemoLobDemo> {

}