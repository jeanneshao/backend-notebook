package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoAssociationFullExampleToEnumVO {

    /**
     * 自增主键
     */
    @NotNull(message = "id can not null")
    private Long id;


    /**
     * 实体主键
     */
    @NotNull(message = "entityId can not null")
    private Long entityId;


    /**
     * 文件主键
     */
    @NotNull(message = "enumId can not null")
    private Long enumId;


    /**
     * 删除标识
     */
    private Integer deletedFlag;

}
