package com.example.jpademo.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class DemoTbUserQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private Long createdTime;

    private String additionalInfo;

    private String authority;

    private String customerId;

    private String email;

    private String firstName;

    private String lastName;

    private String searchText;

    private String tenantId;

}
