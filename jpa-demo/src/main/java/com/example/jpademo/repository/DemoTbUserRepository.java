package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoTbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoTbUserRepository extends JpaRepository<DemoTbUser, String>, JpaSpecificationExecutor<DemoTbUser> {

}