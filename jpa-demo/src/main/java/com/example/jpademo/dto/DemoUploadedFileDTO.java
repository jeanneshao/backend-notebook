package com.example.jpademo.dto;


import lombok.Data;

@Data
public class DemoUploadedFileDTO {

    /**
     * 自增主键
     */
    private Long id;

    private String storageDirectory;

    private String fileName;

    private String fileSuffix;

    private Long fileSize;

    private String comment;

    private Integer deletedFlag;

}
