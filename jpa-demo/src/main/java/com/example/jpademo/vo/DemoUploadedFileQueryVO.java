package com.example.jpademo.vo;


import lombok.Data;

@Data
public class DemoUploadedFileQueryVO {

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
