package com.example.transactionmybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 实体和文件关联表
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Getter
@Setter
@TableName("association_full_example_to_cog")
public class AssociationFullExampleToCog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 实体主键
     */
    private Long entityId;

    /**
     * 选项id
     */
    private Long cogId;

    /**
     * 删除标识
     */
    private Boolean deletedFlag;
}
