package com.example.jpademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "base.customer")
public class DemoCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "created_time", nullable = false)
    private Long createdTime;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "search_text")
    private String searchText;

    @Column(name = "state")
    private String state;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "title")
    private String title;

    @Column(name = "zip")
    private String zip;

}
