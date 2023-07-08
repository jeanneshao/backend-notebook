package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class DemoCustomerVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private String id;

    @NotNull(message = "createdTime can not null")
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
