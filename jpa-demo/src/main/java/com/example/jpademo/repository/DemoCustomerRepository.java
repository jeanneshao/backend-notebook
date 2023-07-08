package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoCustomerRepository extends JpaRepository<DemoCustomer, String>, JpaSpecificationExecutor<DemoCustomer> {

}