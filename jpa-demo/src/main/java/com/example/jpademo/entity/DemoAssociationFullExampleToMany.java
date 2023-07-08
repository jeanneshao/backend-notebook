package com.example.jpademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 关联关系维护表
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "low_code_demo.association_full_example_to_many")
public class DemoAssociationFullExampleToMany {

    /**
     * 自增主键
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_example_id", nullable = false)
    private Long fullExampleId;

    @Column(name = "one_to_many_id", nullable = false)
    private Long oneToManyId;

}
