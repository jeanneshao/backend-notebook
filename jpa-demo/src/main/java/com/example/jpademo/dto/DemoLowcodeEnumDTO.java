package com.example.jpademo.dto;


import lombok.Data;

@Data
public class DemoLowcodeEnumDTO {

    /**
     * 自增主键
     */
    private Long id;

    private String type;

    private String value;

    private String label;

}
