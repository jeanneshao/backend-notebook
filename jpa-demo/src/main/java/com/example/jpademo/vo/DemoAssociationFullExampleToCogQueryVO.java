package com.example.jpademo.vo;


import lombok.Data;

@Data
public class DemoAssociationFullExampleToCogQueryVO {

    /**
     * 自增主键
     */
    private Long id;


    /**
     * 实体主键
     */
    private Long entityId;


    /**
     * 选项id
     */
    private Long cogId;


    /**
     * 删除标识
     */
    private Integer deletedFlag;

}
