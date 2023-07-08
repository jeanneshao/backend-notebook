package com.example.jpademo.dto;


import lombok.Data;

@Data
public class DemoAssociationFullExampleToManyDTO {

    /**
     * 自增主键
     */
    private Long id;

    private Long fullExampleId;

    private Long oneToManyId;

}
