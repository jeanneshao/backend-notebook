package com.example.jdbctemplatedemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class DemoCustomer implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;

    private Long createdTime;

    private String additionalInfo;

    private String address;

    private String address2;

    private String city;

    private String country;

    private String email;

    private String phone;

    private String searchText;

    private String state;

    private String tenantId;

    private String title;

    private String zip;

}
