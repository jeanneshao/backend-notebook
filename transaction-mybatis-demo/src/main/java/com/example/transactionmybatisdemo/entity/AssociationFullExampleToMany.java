package com.example.transactionmybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 关联关系维护表
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Getter
@Setter
@TableName("association_full_example_to_many")
public class AssociationFullExampleToMany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long fullExampleId;

    private Long oneToManyId;
}
