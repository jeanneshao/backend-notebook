package com.example.jpademo.dto;


import lombok.Data;

@Data
public class DemoAssociationFullExampleToFileDTO {

    /**
     * 自增主键
     */
    private Long id;


    /**
     * 实体主键
     */
    private Long entityId;


    /**
     * 文件主键
     */
    private Long fileId;


    /**
     * 删除标识
     */
    private Integer deletedFlag;

}
