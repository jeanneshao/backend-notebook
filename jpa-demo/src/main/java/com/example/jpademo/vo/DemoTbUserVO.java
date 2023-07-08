package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class DemoTbUserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private String id;

    @NotNull(message = "createdTime can not null")
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
