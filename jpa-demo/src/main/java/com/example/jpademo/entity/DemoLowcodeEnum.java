package com.example.jpademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 枚举表
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "low_code_demo.lowcode_enum")
public class DemoLowcodeEnum {

    /**
     * 自增主键
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private String value;

    @Column(name = "label")
    private String label;

}
