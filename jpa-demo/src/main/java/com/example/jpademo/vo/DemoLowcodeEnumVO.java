package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoLowcodeEnumVO {

    /**
     * 自增主键
     */
    @NotNull(message = "id can not null")
    private Long id;

    private String type;

    private String value;

    private String label;

}
