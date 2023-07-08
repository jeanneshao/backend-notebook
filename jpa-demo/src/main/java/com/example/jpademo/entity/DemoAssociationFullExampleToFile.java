package com.example.jpademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 实体和文件关联表
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "low_code_demo.association_full_example_to_file")
public class DemoAssociationFullExampleToFile {

    /**
     * 自增主键
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 实体主键
     */
    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    /**
     * 文件主键
     */
    @Column(name = "file_id", nullable = false)
    private Long fileId;

    /**
     * 删除标识
     */
    @Column(name = "deleted_flag")
    private Integer deletedFlag = 0;

}
