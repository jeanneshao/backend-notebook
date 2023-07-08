package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoRogWithBackendVO {

    /**
     * 自增主键
     */
    @NotNull(message = "id can not null")
    private Long id;

    private String value;

    private String label;

}
