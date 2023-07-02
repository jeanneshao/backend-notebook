package com.example.transaction.entity;

import com.example.transaction.mapping.JsonStringType;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Jeanne 2023/7/2
 **/
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "asset", schema = "base", catalog = "")
public class DemoAsset {
    private UUID id;
    private long createdTime;
    private JsonNode additionalInfo;
    private byte[] customerId;
    private String name;
    private String label;
    private String searchText;
    private byte[] tenantId;
    private String type;
    private Long updateTime;
    private String updOperator;
    private String operator;

    @Id
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_time")
    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    @Type(type = "json")
    @Column(name = "additional_info")
    public JsonNode getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(JsonNode additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Basic
    @Column(name = "customer_id")
    public byte[] getCustomerId() {
        return customerId;
    }

    public void setCustomerId(byte[] customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "search_text")
    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Basic
    @Column(name = "tenant_id")
    public byte[] getTenantId() {
        return tenantId;
    }

    public void setTenantId(byte[] tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "update_time")
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "upd_operator")
    public String getUpdOperator() {
        return updOperator;
    }

    public void setUpdOperator(String updOperator) {
        this.updOperator = updOperator;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoAsset demoAsset = (DemoAsset) o;
        return demoAsset.getId().equals(id);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(createdTime, additionalInfo, name, label, searchText, type, updateTime, updOperator, operator);
        result = 31 * result + id.hashCode();
        result = 31 * result + Arrays.hashCode(customerId);
        result = 31 * result + Arrays.hashCode(tenantId);
        return result;
    }
}
