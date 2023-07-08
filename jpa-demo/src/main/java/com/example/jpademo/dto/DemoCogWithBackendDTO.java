package com.example.jpademo.dto;


import lombok.Data;

@Data
public class DemoCogWithBackendDTO {

    /**
     * 自增主键
     */
    private Long id;

    private String value;

    private String label;

}
