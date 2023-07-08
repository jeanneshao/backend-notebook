package com.example.jdbctemplatedemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class DemoTbUser implements Serializable {

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
