package com.example.transactionmybatisdemo.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.transactionmybatisdemo.entity.DemoAsset;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * entry resource Mapper 接口
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Mapper
@InterceptorIgnore
public interface DemoAssetMapper extends BaseMapper<DemoAsset> {

}
