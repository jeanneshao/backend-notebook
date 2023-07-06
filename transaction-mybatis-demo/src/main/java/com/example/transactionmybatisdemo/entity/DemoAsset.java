package com.example.transactionmybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * entry resource
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Data
@TableName(value ="asset",autoResultMap = true) //不配合 typeHandler 或 numericScale 使用无意义,演示而已
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoAsset implements Serializable {

    private byte[] id;
    private long createdTime;
    @TableField( typeHandler = JacksonTypeHandler.class)
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

}
