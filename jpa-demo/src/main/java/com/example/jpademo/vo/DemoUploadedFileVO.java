package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoUploadedFileVO {

    /**
     * 自增主键
     */
    @NotNull(message = "id can not null")
    private Long id;

    private String storageDirectory;

    private String fileName;

    private String fileSuffix;

    private Long fileSize;

    private String comment;

    private Integer deletedFlag;

}
