package com.example.jpademo.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class DemoAssetQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private Long createdTime;

    private String additionalInfo;

    private String customerId;

    private String name;

    private String label;

    private String searchText;

    private String tenantId;

    private String type;

    private Long updateTime;

    private String updOperator;

    private String operator;

}
