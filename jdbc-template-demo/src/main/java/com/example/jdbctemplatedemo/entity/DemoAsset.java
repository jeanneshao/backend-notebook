package com.example.jdbctemplatedemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class DemoAsset implements Serializable {

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
