package com.example.jpademo.vo;


import lombok.Data;

@Data
public class DemoAssociationFullExampleToEnumQueryVO {

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
    private Long enumId;


    /**
     * 删除标识
     */
    private Integer deletedFlag;

}
