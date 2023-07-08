package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoAssociationFullExampleToCogVO {

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
     * 选项id
     */
    @NotNull(message = "cogId can not null")
    private Long cogId;


    /**
     * 删除标识
     */
    private Integer deletedFlag;

}
