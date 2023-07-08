package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoLowcodeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoLowcodeEnumRepository extends JpaRepository<DemoLowcodeEnum, Long>, JpaSpecificationExecutor<DemoLowcodeEnum> {

}