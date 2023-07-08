package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoAssociationFullExampleToManyVO {

    /**
     * 自增主键
     */
    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "fullExampleId can not null")
    private Long fullExampleId;

    @NotNull(message = "oneToManyId can not null")
    private Long oneToManyId;

}
