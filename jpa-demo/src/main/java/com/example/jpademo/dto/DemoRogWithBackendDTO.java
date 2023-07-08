package com.example.jpademo.dto;


import lombok.Data;

@Data
public class DemoRogWithBackendDTO {

    /**
     * 自增主键
     */
    private Long id;

    private String value;

    private String label;

}
