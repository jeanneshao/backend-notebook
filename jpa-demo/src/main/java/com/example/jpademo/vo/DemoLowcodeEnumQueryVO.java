package com.example.jpademo.vo;


import lombok.Data;

@Data
public class DemoLowcodeEnumQueryVO {

    /**
     * 自增主键
     */
    private Long id;

    private String type;

    private String value;

    private String label;

}
