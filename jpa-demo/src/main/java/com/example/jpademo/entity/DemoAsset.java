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
@Table(name = "base.asset")
public class DemoAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "created_time", nullable = false)
    private Long createdTime;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "label")
    private String label;

    @Column(name = "search_text")
    private String searchText;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "type")
    private String type;

    @Column(name = "update_time")
    private Long updateTime;

    @Column(name = "upd_operator")
    private String updOperator;

    @Column(name = "operator")
    private String operator;

}
