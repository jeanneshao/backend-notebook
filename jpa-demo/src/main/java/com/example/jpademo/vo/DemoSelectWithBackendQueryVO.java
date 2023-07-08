package com.example.jpademo.vo;


import lombok.Data;

@Data
public class DemoSelectWithBackendQueryVO {

    /**
     * 自增主键
     */
    private Long id;

    private String value;

    private String label;

}
