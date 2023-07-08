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
@Table(name = "base.tb_user")
public class DemoTbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "created_time", nullable = false)
    private Long createdTime;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "authority")
    private String authority;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "search_text")
    private String searchText;

    @Column(name = "tenant_id")
    private String tenantId;

}
