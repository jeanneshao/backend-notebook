package com.example.jpademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 上传文件管理表
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "low_code_demo.uploaded_file")
public class DemoUploadedFile {

    /**
     * 自增主键
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "storage_directory")
    private String storageDirectory;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_suffix")
    private String fileSuffix;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "comment")
    private String comment;

    @Column(name = "deleted_flag")
    private Integer deletedFlag = 0;

}
