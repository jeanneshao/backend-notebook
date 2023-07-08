package com.example.jpademo.vo;


import lombok.Data;

@Data
public class DemoAssociationFullExampleToManyQueryVO {

    /**
     * 自增主键
     */
    private Long id;

    private Long fullExampleId;

    private Long oneToManyId;

}
