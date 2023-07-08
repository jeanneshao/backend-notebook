package com.example.jpademo.repository;

import com.example.jpademo.entity.DemoUploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoUploadedFileRepository extends JpaRepository<DemoUploadedFile, Long>, JpaSpecificationExecutor<DemoUploadedFile> {

}